package nc.service;

import java.util.List;
import nc.dao.UserRoleDao;
import nc.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao dao;

    @Override
    public UserRole findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveUserRole(UserRole toSave) {
        dao.saveUserRole(toSave);
    }

    @Override
    public void updateUser(UserRole toUpdate) {
        UserRole entity = dao.findById(toUpdate.getUserRoleId());
        if (entity != null) {
            entity.setRole(toUpdate.getRole());
            entity.setUser(toUpdate.getUser());
        }
    }

    @Override
    public List<UserRole> findAllUserRole() {
        return dao.findAll();
    }

}
