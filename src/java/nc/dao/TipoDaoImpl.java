package nc.dao;

import java.util.List;
import nc.model.Tipo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author riccardo
 */
@Repository("TipoDao")
public class TipoDaoImpl implements TipoDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Tipo findByNome(String nome) {
        return (Tipo) getSession().get(Tipo.class, nome);
    }

    @Override
    public void saveTipo(Tipo toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Tipo> findAll() {
        Criteria criteria = getSession().createCriteria(Tipo.class);
        return (List<Tipo>) criteria.list();
    }

}
