package com.dd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dd.dao.UserDao;
import com.dd.po.User;
import com.dd.service.UserService;

@Service("userService")

public class UserServiceImpl implements UserService{

	//×¢ÈëUserDao
	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(String usercode, String password) {
		User user = this.userDao.findUser(usercode, password);
		return user;
	}
	
	@Override
	public int addUser(String usercode,String password,String username,String userstate){
		int user =this.userDao.addUser(usercode, password, username, userstate);
		return user;
	}
	
}
