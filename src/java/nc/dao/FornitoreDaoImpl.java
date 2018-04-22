package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Fornitore;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        String sql = "SELECT * FROM Fornitori";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(Fornitore.class);
        return new ArrayList<>(query.list());
    }
}
