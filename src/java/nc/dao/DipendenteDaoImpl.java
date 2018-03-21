package nc.dao;

import java.util.List;
import nc.model.Dipendente;
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
        Criteria criteria = getSession().createCriteria(Dipendente.class);
        return (List<Dipendente>) criteria.list();
    }

}
