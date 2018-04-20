package nc.dao;

import java.util.List;
import nc.model.Reparto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("RepartoDao")
public class RepartoDaoImpl implements RepartoDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Reparto findByID(int id) {
        return (Reparto) getSession().get(Reparto.class, id);
    }

    @Override
    public void saveReparto(Reparto toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Reparto> findAll() {
        Criteria criteria = getSession().createCriteria(Reparto.class);
        return (List<Reparto>) criteria.list();
    }
}
