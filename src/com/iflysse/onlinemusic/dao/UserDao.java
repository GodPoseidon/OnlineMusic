package com.iflysse.onlinemusic.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iflysse.onlinemusic.po.User;
@Repository
public interface UserDao {
	public User getUser(@Param("email")String email, @Param("password")String password);

	public void add(User user);
}
