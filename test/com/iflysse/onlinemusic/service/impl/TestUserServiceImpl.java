package com.iflysse.onlinemusic.service.impl;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iflysse.onlinemusic.po.User;
import com.iflysse.onlinemusic.service.UserService;

public class TestUserServiceImpl {
	UserService service=new UserServiceImpl();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getUser() {
		User user=service.getUser("lisi@qq.com", "2222");
		System.out.println(user.toString());
	}
	@Test
	public void add(){
		User user=new User();
		user.setNname("xiaohua");
		user.setEmail("xiaohua@qq.com");
		user.setPassword("3333");
		service.add(user);
	}

}
