package com.collaborate.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
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

	public boolean isUsernameValid(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean registerUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.save(user);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean isUserNameValid(String username) {
		Session session=sessionFactory.getCurrentSession();

	public boolean isEmailValid(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from user where email=?");
		query.setString
		return false;
	}
	public User login(User user){
		Session session=sessionFactory.getCurrentSession();
		Query query=setString(0, user.getUsername());
		Query query=session.createQuery("from User where username=? and password=?");
		Query query=setString(0, user.getPassword());
		user=(User)query.uniqueResult();
		return user;
		
	}
	public void update(User user){
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
				
	}
	public User getUserByUsername(String username){
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,username);
		return user;
		
	}
	public boolean isUpdatedEmailValid(String email,String username){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email = ? and username = ?");
		query.setString(0, email);
		query.setString(1, username);
		User user=(User)query.uniqueResult();
		if(user==null)
		return true;
		else
	    return false;
		
		}
	
}
