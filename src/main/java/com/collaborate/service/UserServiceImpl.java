package com.collaborate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.UserDAO;
import com.collaborate.Model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	public boolean registerUser(User user)
	{
		return userDAO.registerUser(user);
	}
	public boolean isUsernameValid(String username){
		return userDAO.isUsernameValid(username);
	}
	public boolean isEmailValid(String email) {
		return userDAO.isEmailValid(email);
	}

}
