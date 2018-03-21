package nc.dao;

import java.util.List;
import nc.model.Elaborazione;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        Criteria criteria = getSession().createCriteria(Elaborazione.class);
        return (List<Elaborazione>) criteria.list();
    }
    
}
