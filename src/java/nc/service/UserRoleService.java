package nc.service;

import java.util.List;
import nc.model.UserRole;

/**
 *
 * @author riccardo
 */
public interface UserRoleService {
    UserRole findById(int id);
    void saveUserRole(UserRole toSave);
    void updateUser(UserRole toUpdate);
    List<UserRole> findAllUserRole();
}
