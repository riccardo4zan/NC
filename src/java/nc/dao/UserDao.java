package nc.dao;

import java.util.List;
import nc.model.User;

public interface UserDao {

    User findByUserName(String username);
    void saveUser(User toSave);
    List<User> findAll();
}
