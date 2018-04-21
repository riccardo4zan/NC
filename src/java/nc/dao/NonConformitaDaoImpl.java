package nc.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("NonConformitaDao")
public class NonConformitaDaoImpl implements NonConformitaDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public NonConformita findByCodice(int codice) {
        return (NonConformita) getSession().get(NonConformita.class, codice);
    }

    @Override
    public void saveNonConformita(NonConformita toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<NonConformita> findAll() {
        String sql = "SELECT * FROM NonConformita";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(NonConformita.class);
        return new ArrayList<>(query.list());
    }

    @Override
    public double findCostoPerTipo(int anno, Tipo tipo) {
        Query query = getSession().createSQLQuery(
                "SELECT * FROM NonConformita WHERE Tipo = :nome_tipo AND (year(DataChiusura) = :anno OR isnull(DataChiusura))")
                .addEntity(NonConformita.class)
                .setParameter("nome_tipo", tipo.getNome())
                .setParameter("anno", anno);
        ArrayList<NonConformita> res = new ArrayList<>(query.list());
        double sum = 0;
        if (res != null) {
            for (NonConformita tmp : res) {
                sum += tmp.getCosto();
            }
        }
        return sum;
    }

    @Override
    public double findCostoPerReparto(int anno, Reparto rep) {
        Query query = getSession().createSQLQuery(
                "SELECT * FROM NonConformita WHERE IDReparto = :reparto AND (year(DataChiusura) = :anno OR isnull(DataChiusura))")
                .addEntity(NonConformita.class)
                .setParameter("reparto", rep.getId())
                .setParameter("anno", anno);
        ArrayList<NonConformita> res = new ArrayList<>(query.list());
        double sum = 0;
        if (res != null) {
            for (NonConformita tmp : res) {
                sum += tmp.getCosto();
            }
        }
        return sum;
    }

    @Override
    public double findCostoPerFornitore(int anno, Fornitore forn) {
        Query query = getSession().createSQLQuery(
                "SELECT * FROM NonConformita WHERE PivaFornitore = :piva AND (year(DataChiusura) = :anno OR isnull(DataChiusura))")
                .addEntity(NonConformita.class)
                .setParameter("piva", forn.getPiva())
                .setParameter("anno", anno);
        ArrayList<NonConformita> res = new ArrayList<>(query.list());
        double sum = 0;
        if (res != null) {
            for (NonConformita tmp : res) {
                sum += tmp.getCosto();
            }
        }
        return sum;
    }

    @Override
    public double findAllCostoPerNonConformita(int anno) {
        int a = Calendar.YEAR;
        String sql = "SELECT * FROM NonConformita WHERE year(DataApertura) = :annoI AND (year(DataChiusura) = :anno OR isnull(DataChiusura))";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(NonConformita.class);
        query.setParameter("annoI", a);
        query.setParameter("annoF", anno);
        ArrayList<NonConformita> res = new ArrayList<>(query.list());
        double sum = 0;
        if (res != null) {
            for (NonConformita tmp : res) {
                sum += tmp.getCosto();
            }
        }
        return sum;
    }

    @Override
    public List<NonConformita> findAllAperte() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNull("dataChiusura"));
        criteria.add(Restrictions.isNull("azioniCorrettive"));
        return (List<NonConformita>) criteria.list();
    }

    @Override
    public List<NonConformita> findAllInElaborazione() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNull("dataChiusura"));
        criteria.add(Restrictions.isNotNull("azioniCorrettive"));
        return (List<NonConformita>) criteria.list();
    }

    @Override
    public List<NonConformita> findAllChiuse() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNotNull("dataChiusura"));
        return (List<NonConformita>) criteria.list();
    }

    public double findCostoAnnoPerMese(int mese, int anno) {
        Query query = getSession().createSQLQuery(
                "SELECT * FROM NonConformita WHERE year(DataChiusura) = :anno AND month(DataChiusura)=:mese ")
                .addEntity(NonConformita.class)
                .setParameter("mese", mese)
                .setParameter("anno", anno);
        ArrayList<NonConformita> res = new ArrayList<>(query.list());
        double sum = 0;
        if (res != null) {
            for (NonConformita tmp : res) {
                sum += tmp.getCosto();
            }
        }
        return sum;
    }

}
