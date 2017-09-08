package com.collaborate.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
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

	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> getBlogs() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}
}
