package com.iflysse.onlinemusic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iflysse.onlinemusic.dao.UserDao;
import com.iflysse.onlinemusic.po.User;
import com.iflysse.onlinemusic.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private	UserDao userDao;
	
	@Override
	public User getUser(String email, String password) {
		return userDao.getUser(email, password);
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

}
