package com.dd.dao;

import org.apache.ibatis.annotations.Param;

import com.dd.po.User;

public interface UserDao {
	
	public User findUser(@Param("usercode") String usercode,@Param("password") String password);
	
	public int addUser(@Param("usercode") String usercode,@Param("password") String password,
			@Param("username") String username,@Param("userstate") String userstate);
	
}
