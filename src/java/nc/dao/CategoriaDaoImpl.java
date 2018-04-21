package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Categoria;
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
@Repository("CategoriaDao")
public class CategoriaDaoImpl implements CategoriaDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Categoria findByCodice(int codice) {
        return (Categoria) getSession().get(Categoria.class, codice);
    }

    @Override
    public void saveCategoria(Categoria toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Categoria> findAllCategorie() {
        String sql = "SELECT * FROM Categorie";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(Categoria.class);
        return new ArrayList<>(query.list());
    }

}
