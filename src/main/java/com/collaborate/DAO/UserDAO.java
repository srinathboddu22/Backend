package com.collaborate.DAO;

import java.util.List;

import com.collaborate.Model.Blog;
import com.collaborate.Model.User;

public interface UserDAO {

	
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
}
