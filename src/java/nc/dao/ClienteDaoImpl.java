package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Cliente;
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
        String sql = "SELECT * FROM Clienti";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(Cliente.class);
        return new ArrayList<>(query.list());
    }
      
}
