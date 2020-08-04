package com.vastika.user_demo_jdbc_1.service;

import java.util.List;

import com.vastika.user_demo_jdbc_1.dao.UserDao;
import com.vastika.user_demo_jdbc_1.dao.UserDaoImp;
import com.vastika.user_demo_jdbc_1.model.User;

public class UserServiceImpl implements UserService {
UserDao userDao=new UserDaoImp();
	
	@Override
	public int saveUserInfo(User user) {
		
		return userDao.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(User user) {
	
		return userDao.updateUserInfo(user);
	}

	@Override
	public void deleteuserInfo(int id) {
		userDao.deleteuserInfo(id);
		
	}

	@Override
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		
		return userDao.getAllUserInfo();
	}

}
