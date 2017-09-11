package com.collaborate.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.Model.Blog;
import com.collaborate.Model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean createForum(Forum forum)
	{
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised"+e);
		return false;
	}
	
}
	@Transactional
	public Forum getForumdetails(int forumId) {
		
		try
		{
			
			
			 return  (Forum)sessionFactory.getCurrentSession().createQuery("from Forum where forumId="+forumId);
			
			
		}
		catch(Exception e)
		{
			 System.out.println("Exception Arised"+e);
			 return null;
		}
	}
	@Transactional
	public List<Forum> getForum() {
		
		 @SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) sessionFactory.getCurrentSession().createQuery("from Forum");
		 return listForum;
	}
	@Transactional
	public boolean approveForum(Forum forum) {
		
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}
	@Transactional
	public boolean editForum(int forumId) {
		
		try
		{
			
			@SuppressWarnings("rawtypes")
			Query query = (Query) sessionFactory.getCurrentSession().createQuery("update Forum where forumId="+forumId);
			  query.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
				System.out.println("Exception Arised"+e);
			 return false;
		}
	}
	@Transactional
	public boolean deleteForum(int forumId) {
		
		try
		{
			
			sessionFactory.getCurrentSession().delete(forumId);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}
	
	
}
