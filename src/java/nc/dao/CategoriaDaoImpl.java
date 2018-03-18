package nc.dao;

import java.util.List;
import nc.model.Categoria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author riccardo
 */
public class CategoriaDaoImpl implements CategoriaDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Categoria findByCodice(String codice) {
        return (Categoria) getSession().get(Categoria.class, codice);
    }

    @Override
    public void saveCategoria(Categoria toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<Categoria> findAllCategorie() {
        Criteria criteria = getSession().createCriteria(Categoria.class);
        return (List<Categoria>) criteria.list();
    }

}
