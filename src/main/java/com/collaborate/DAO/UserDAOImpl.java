package com.collaborate.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.Model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{	
	
	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createUser1(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
			
		}
	}

	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
