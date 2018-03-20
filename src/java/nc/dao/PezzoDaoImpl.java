package nc.dao;

import java.util.List;
import nc.model.Pezzo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Repository("PezzoDao")
public class PezzoDaoImpl implements PezzoDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Pezzo findByCodice(int codice) {
        return (Pezzo) getSession().get(Pezzo.class, codice);
    }

    @Override
    public void savePezzo(Pezzo toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Pezzo> findAll() {
        Criteria criteria = getSession().createCriteria(Pezzo.class);
        return (List<Pezzo>) criteria.list();
    }

}
