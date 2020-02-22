package com.dd.service;

import com.dd.po.User;

public interface UserService {

	public User findUser(String usercode,String password);
	public int addUser(String usercode,String password,String username,String userstate); 
	
}
