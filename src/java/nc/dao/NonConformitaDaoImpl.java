package nc.dao;

import java.util.List;
import nc.model.NonConformita;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author riccardo
 */
public class NonConformitaDaoImpl implements NonConformitaDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public NonConformita findByCodice(int codice) {
        return (NonConformita) getSession().get(NonConformita.class, codice);
    }

    @Override
    public void saveNonConformita(NonConformita toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<NonConformita> findAll() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        return (List<NonConformita>) criteria.list();
    }
    
}
