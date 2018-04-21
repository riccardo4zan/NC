package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Pezzo;
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
        String sql = "SELECT * FROM Pezzi";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(Pezzo.class);
        return new ArrayList<>(query.list());
    }

}
