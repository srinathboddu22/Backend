package com.collaborate.DAO;

import java.util.List;

import com.collaborate.Model.User;

public interface UserDao 
{
	void registration(User user);
	List<User> getAllUser();
	User login(User user);
	User updateUser(User validUser);
	User getUserByUsername(int id);
	
}