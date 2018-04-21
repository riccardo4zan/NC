package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Dipendente;
import nc.model.Elaborazione;
import nc.model.Reparto;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author riccardo
 */
@Repository("ElaborazioneDao")
public class ElaborazioneDaoImpl implements ElaborazioneDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Elaborazione findByCodice(int codice) {
        return (Elaborazione) getSession().get(Elaborazione.class, codice);
    }

    @Override
    public void saveElaborazione(Elaborazione toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Elaborazione> findAll() {
        String sql = "SELECT * FROM Elaborazioni";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(Elaborazione.class);
        return new ArrayList<>(query.list());
    }

    @Override
    public List<Elaborazione> findOpen(Dipendente dip) {
        Criteria criteria = getSession().createCriteria(Elaborazione.class);
        criteria.add(Restrictions.eq("dipendente",dip));
        criteria.add(Restrictions.isNull("dataFine"));
        return (List<Elaborazione>) criteria.list();
    }

    @Override
    public List<Elaborazione> findClose(Dipendente dip) {
        Criteria criteria = getSession().createCriteria(Elaborazione.class);
        criteria.add(Restrictions.eq("dipendente",dip));
        criteria.add(Restrictions.isNotNull("dataFine"));
        return (List<Elaborazione>) criteria.list();
    }
    
}
