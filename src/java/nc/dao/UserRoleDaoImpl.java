package nc.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import nc.model.UserRole;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public UserRole findById(int id) {
        Criteria criteria = getSession().createCriteria(UserRole.class);
        criteria.add(Restrictions.eq("user_role_id", id));
        List<UserRole> ur = criteria.list();
        if (ur.size() > 0) {
            return ur.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<UserRole> findAll() {
        Criteria criteria = getSession().createCriteria(UserRole.class);
        return (List<UserRole>) criteria.list();
    }

    @Override
    public void saveUserRole(UserRole toSave) {
        getSession().persist(toSave);
    }

}
