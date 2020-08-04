package com.vastika.user_demo_jdbc_1.dao;

import java.util.List;

import com.vastika.user_demo_jdbc_1.model.User;

public interface UserDao {
	
	int saveUserInfo(User user);
	
	int updateUserInfo(User user);
	
	void deleteuserInfo(int id);
	
	User getUserById(int id);
	
	List<User> getAllUserInfo();
	

}
