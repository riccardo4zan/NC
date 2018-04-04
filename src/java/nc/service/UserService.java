package nc.service;

import java.util.List;
import nc.model.User;

/**
 *
 * @author riccardo
 */
public interface UserService {
    User findByUserName(String username);
    void saveUser(User toSave);
    void updateUser(User toUpdate);
    List<User> findAllUsers();
}
