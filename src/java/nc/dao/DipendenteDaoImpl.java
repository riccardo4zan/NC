package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Dipendente;
import nc.model.Reparto;
import org.hibernate.Criteria;
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
public class DipendenteDaoImpl implements DipendenteDao{

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

}
