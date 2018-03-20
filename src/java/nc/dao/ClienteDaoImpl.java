package nc.dao;

import java.util.List;
import nc.model.Cliente;
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
@Repository("ClienteDao")
public class ClienteDaoImpl implements ClienteDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Cliente findByPiva(String piva) {
        return (Cliente) getSession().get(Cliente.class, piva);
    }

    @Override
    public void saveCliente(Cliente toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Cliente> findAllClienti() {
        Criteria criteria = getSession().createCriteria(Cliente.class);
        return (List<Cliente>) criteria.list();
    }
      
}
