package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Segnalazione;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author riccardo
 */
@Repository("SegnalazioneDao")
public class SegnalazioneDaoImpl implements SegnalazioneDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Segnalazione findByCodice(int codice) {
        return (Segnalazione) getSession().get(Segnalazione.class, codice);
    }

    @Override
    public void saveSegnalazione(Segnalazione toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Segnalazione> findAll() {
        String sql = "SELECT * FROM Segnalazioni ORDER BY Data ASC";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(Segnalazione.class);
        return new ArrayList<>(query.list());
    }

}
