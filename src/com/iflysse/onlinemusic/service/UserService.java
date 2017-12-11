package com.iflysse.onlinemusic.service;

import com.iflysse.onlinemusic.po.User;

public interface UserService {
	public User getUser(String email, String password);

	public void add(User user);
}
