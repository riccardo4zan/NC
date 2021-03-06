package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Dipendente;
import nc.model.Reparto;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author riccardo
 */
@Repository("DipendenteDao")
public class DipendenteDaoImpl implements DipendenteDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Dipendente findByMatricola(int matricola) {
        return (Dipendente) getSession().get(Dipendente.class, matricola);
    }

    @Override
    public void saveDipendente(Dipendente toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Dipendente> findAll() {
        String sql = "SELECT * FROM Dipendenti";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(Dipendente.class);
        return new ArrayList<>(query.list());
    }

    @Override
    public List<Dipendente> findAllOperaiReparto(int reparto) {
        Query query = getSession().createSQLQuery(
                "SELECT D.Matricola, D.Nome, D.Cognome, D.Reparto, D.Username FROM Dipendenti D,users U,user_roles US WHERE D.Username=U.username AND U.username= US.username AND US.role='ROLE_OPERAIO' AND D.Reparto=:nome_reparto") 
                .addEntity(Dipendente.class)
                .setParameter("nome_reparto", reparto);
                
        return (List<Dipendente>) query.list();
    }
    
    public List<Dipendente> findAllSenzaManager() {
        Query query = getSession().createSQLQuery(
                "SELECT D.Matricola, D.Nome, D.Cognome, D.Reparto, D.Username FROM Dipendenti D,users U,user_roles US WHERE D.Username=U.username AND U.username= US.username AND US.role!='ROLE_MANAGER' ") 
                .addEntity(Dipendente.class);
                
        return (List<Dipendente>) query.list();
    }
    
         public List<Dipendente> findAllLiberi(int codice) {
        Query query = getSession().createSQLQuery(
                "SELECT D.Matricola,D.Nome,D.cognome,D.Reparto,D.Username FROM Dipendenti AS D ,users AS U, user_roles AS US WHERE D.Username=U.username AND U.username= US.username AND US.role!='ROLE_MANAGER' AND D.Matricola NOT IN (SELECT MatricolaDipendente FROM CTeam WHERE CodiceNC=:codice)") 
                .addEntity(Dipendente.class)
                .setParameter("codice",codice);
                
        return (List<Dipendente>) query.list();
    }
}