package com.collaborate.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.Model.User;
@Repository
public class UserDaoImpl implements UserDao
{
	
@Autowired
private SessionFactory sessionFactory;

public void registration(User user) 
{
	Session session=sessionFactory.openSession();

	Transaction tx=session.beginTransaction();
	user.setEnabled(true);
	user.setOnline(false);
	session.save(user);
	tx.commit();
	session.flush();
	session.close();
}
	
	public List<User> getAllUser() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from user");
		List<User> user=query.list();
		session.close();
		return user;
	}
	
	public User login(User user)
	{
		System.out.println(user.getUsername()+""+user.getPassword());
		Session session=sessionFactory.openSession();
		System.out.println("hello");
		Query query=session.createQuery("from Users where username=? and password=? and enabled=?");
		System.out.println("hell");
		query.setString(0, user.getUsername()); //for assigning the values to parameter username
		query.setString(1, user.getPassword());
		query.setBoolean(2, true);
		User validUser=(User)query.uniqueResult();
		session.close();
		System.out.println("Dao completed");
		return validUser;
		
	}
	
	public User updateUser(User validUser)
	{
		Session session=sessionFactory.openSession();
		session.update(validUser);
		session.flush();
		session.close();
		return validUser;
	}

	public User getUserByUsername(int id)
	{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class, id);
		session.close();
		return user;
	}

	
}