package nc.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author riccardo
 */
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
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        return (List<NonConformita>) criteria.list();
    }

    @Override
    public int findCostoPerTipo(Date anno, Tipo tipo) {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        //raggruppa per tipo, e anno
        criteria.add(Restrictions.eq("tipo", tipo));
        criteria.add(Restrictions.eq("dataChiusura", anno));
        ArrayList<NonConformita> res = new ArrayList<>(criteria.list());
        int sum = 0;
        for (NonConformita tmp : res) {
            sum += tmp.getCosto();
        }
        return sum;
    }

    @Override
    public int findCostoPerReparto(Date anno, Reparto rep) {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        //raggruppa per tipo, e anno
        criteria.add(Restrictions.eq("reparto", rep));
        criteria.add(Restrictions.eq("dataChiusura", anno));
        ArrayList<NonConformita> res = new ArrayList<>(criteria.list());
        int sum = 0;
        for (NonConformita tmp : res) {
            sum += tmp.getCosto();
        }
        return sum;
    }

    @Override
    public int findCostoPerFornitore(Date anno, Fornitore forn) {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        //raggruppa per tipo, e anno
        criteria.add(Restrictions.eq("fornitore", forn));
        criteria.add(Restrictions.eq("dataChiusura", anno));
        ArrayList<NonConformita> res = new ArrayList<>(criteria.list());
        int sum = 0;
        for (NonConformita tmp : res) {
            sum += tmp.getCosto();
        }
        return sum;
    }

}
