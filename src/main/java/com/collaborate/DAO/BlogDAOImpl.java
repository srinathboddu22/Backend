package com.collaborate.DAO;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.Model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean createBlog(Blog blog)
	{
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised"+e);
		return false;
	}
	
}
	@Transactional
	public Blog getBlog(int blogId) {
		
		try
		{
			
			
			 return  (Blog)sessionFactory.getCurrentSession().createQuery("from Blog where blogId="+blogId);
			
			
		}
		catch(Exception e)
		{
			 System.out.println("Exception Arised"+e);
			 return null;
		}
	}
	@Transactional
	public List<Blog> getBlogs() {
		
		 @SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) sessionFactory.getCurrentSession().createQuery("from Blog");
		 return listBlog;
	}
	@Transactional
	public boolean approveBlog(Blog blog) {
		
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}
	@Transactional
	public boolean editBlog(int blogId) {
		
		try
		{
			
			@SuppressWarnings("rawtypes")
			Query query = (Query) sessionFactory.getCurrentSession().createQuery("update Blog set  blogId=?,blogName=?,blogContent=?,status=?,username=?,likes=?,createDate=? where blogId="+blogId);
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
	public boolean deleteBlog(int blogId) {
		
		try
		{
			
			sessionFactory.getCurrentSession().delete(blogId);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}

}