package nc.dao;

import java.util.List;
import nc.model.Fornitore;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author riccardo
 */
@Repository("FornitoreDao")
public class FornitoreDaoImpl implements FornitoreDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Fornitore findByPiva(String piva) {
        return (Fornitore) getSession().get(Fornitore.class, piva);
    }

    @Override
    public void saveFornitore(Fornitore toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Fornitore> findAll() {
        Criteria criteria = getSession().createCriteria(Fornitore.class);
        return (List<Fornitore>) criteria.list();
    }
}
