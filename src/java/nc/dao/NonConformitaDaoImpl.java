package nc.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public double findCostoNCPerAnno(int anno) {
        Query query = getSession().createSQLQuery(
                "SELECT * FROM NonConformita WHERE year(DataChiusura) = :anno")
                .addEntity(NonConformita.class)
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
    public List<NonConformita> findAllAperte() {
        String sql = "SELECT * FROM NonConformita WHERE isnull(DataChiusura) AND isnull(AzioniCorrettive) ";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(NonConformita.class);
        return new ArrayList<>(query.list());
    }


    @Override
    public List<NonConformita> findAllInElaborazione() {
        String sql = "SELECT * FROM NonConformita WHERE isnull(DataChiusura) AND AzioniCorrettive IS NOT NULL ";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(NonConformita.class);
        return new ArrayList<>(query.list());
    }


    @Override
    public List<NonConformita> findAllChiuse() {
        String sql = "SELECT * FROM NonConformita WHERE DataChiusura IS NOT NULL ";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(NonConformita.class);
        return new ArrayList<>(query.list());
    }

    @Override
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

    @Override
    public int findNumeroNCAnno(int anno) {
        Query query = getSession().createSQLQuery(
                "SELECT count(*) FROM NonConformita WHERE year(DataChiusura) = :anno OR isnull(DataChiusura)")
                .setParameter("anno", anno);
        return ((BigInteger) query.uniqueResult()).intValue();
    }
    
    @Override
    public String findTipoNCProblematico(){
        Query query = getSession().createSQLQuery("SELECT Tipo FROM NonConformita GROUP BY Tipo HAVING count(*)=(SELECT max(massimo) from (select count(*) as massimo from NonConformita group by Tipo) as tmp);");
        return (String) query.list().get(0);
    }
    
    @Override
    public int findNumeroNCPerReparto(int anno, int codice) {
        Query query = getSession().createSQLQuery(
                "SELECT count(*) FROM NonConformita WHERE (year(DataChiusura) = :anno OR isnull(DataChiusura)) AND IDReparto = :reparto")
                .setParameter("anno", anno)
                .setParameter("reparto", codice);
        return ((BigInteger) query.uniqueResult()).intValue();
    }
    
    @Override
    public int findNumeroNCReparti(int anno) {
        Query query = getSession().createSQLQuery(
                "SELECT count(*) FROM NonConformita WHERE (year(DataChiusura) = :anno OR isnull(DataChiusura)) AND IDReparto IS NOT NULL")
                .setParameter("anno", anno);
        return ((BigInteger) query.uniqueResult()).intValue();
    }
    
    @Override
    public int findNumeroNCClienti(int anno) {
        Query query = getSession().createSQLQuery(
                "SELECT count(*) FROM NonConformita WHERE (year(DataChiusura) = :anno OR isnull(DataChiusura)) AND PivaCliente IS NOT NULL")
                .setParameter("anno", anno);
        return ((BigInteger) query.uniqueResult()).intValue();
    }
    
    @Override
    public int findNumeroNCFornitori(int anno) {
        Query query = getSession().createSQLQuery(
                "SELECT count(*) FROM NonConformita WHERE (year(DataChiusura) = :anno OR isnull(DataChiusura)) AND PivaFornitore")
                .setParameter("anno", anno);
        return ((BigInteger) query.uniqueResult()).intValue();
    }
    
    @Override
    public int findNumAnnoPerMese(int mese, int anno) {
        Query query = getSession().createSQLQuery(
                "SELECT count(*) FROM NonConformita WHERE year(DataApertura) = :anno AND month(DataApertura)=:mese ")
                .setParameter("mese", mese)
                .setParameter("anno", anno);
        return ((BigInteger) query.uniqueResult()).intValue();
    }
 
}
