package com.collaborate.DAO;

import java.util.List;

import com.collaborate.Model.Blog;
import com.collaborate.Model.User;

public interface UserDAO {

	/*
	public boolean approveUser(User user);
	public boolean editUser(int userId);
	public boolean deleteUser(int userId);
	public boolean isUsernameValid(String username);
	public boolean registerUser(User user);
	public boolean isEmailValid(String email);
	User login(User user);
	void update(User user);
	User getUserByUsername(String username);
	public boolean isUpdatedEmailValid(String email,String username);
	*/
	
	
	public void saveOrUpdate(User users);
	public void delete(User user);
	public User getUser(String username);
	public User viewUser(int userid);
	public List<User> UserList();
	public boolean registerUser(User user);
	public User login(User user);
	public boolean isUsernameValid(String username);
	public boolean isEmailValid(String email);
}

