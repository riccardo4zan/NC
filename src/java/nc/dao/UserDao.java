package nc.dao;

import nc.model.User;

public interface UserDao {

	User findByUserName(String username);

}