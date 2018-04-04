package nc.dao;

import java.util.List;
import nc.model.UserRole;

/**
 *
 * @author riccardo
 */
public interface UserRoleDao {
    UserRole findById(int id);
    void saveUserRole(UserRole toSave);
    List<UserRole> findAll();
}
