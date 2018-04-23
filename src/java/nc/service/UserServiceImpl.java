package nc.service;

import java.util.List;
import nc.dao.UserDao;
import nc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User findByUserName(String username) {
        return dao.findByUserName(username);
    }

    @Override
    public void saveUser(User toSave) {
        dao.saveUser(toSave);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAll();
    }

    @Override
    public void updateUser(User toUpdate) {
        User entity = dao.findByUserName(toUpdate.getUsername());
        if (entity != null) {
            entity.setDip(toUpdate.getDip());
            entity.setEnabled(toUpdate.isEnabled());
            entity.setPassword(toUpdate.getPassword());
            entity.setUserRole(toUpdate.getUserRole());
        }
    }

}
