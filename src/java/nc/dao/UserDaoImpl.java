package nc.dao;

import java.util.ArrayList;
import java.util.List;
import nc.model.Reparto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import nc.model.User;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findByUserName(String username) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<User> users = criteria.list();
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void saveUser(User toSave) {
        getSession().persist(toSave);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(User.class);
        return new ArrayList<>(query.list());
    }

}
