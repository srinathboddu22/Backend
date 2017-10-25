package com.collaborate.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.Model.BlogComment;

@Repository("blogcommentDAO")
public class BlogCommentDaoImpl implements BlogCommentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogCommentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean createBlog(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		
			try
			{
				sessionFactory.getCurrentSession().saveOrUpdate(blogcomment);
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
				return false;
			}
		
	}
	@Transactional
	public BlogComment getBlogcommentdetails(int id) {
		try
		{
			
			
			 return  (BlogComment)sessionFactory.getCurrentSession().createQuery("from BlogComment where blogId="+id);
			
			
		}
		catch(Exception e)
		{
			 System.out.println("Exception Arised"+e);
			 return null;
		}
	}
	@Transactional
	public List<BlogComment> getBlogComment() {
		// TODO Auto-generated method stub
		List<BlogComment> listBlogcomment = (List<BlogComment>) sessionFactory.getCurrentSession().createQuery("from BlogComment");
		 return listBlogcomment;
		
	}
	@Transactional
	public boolean editBlogComment(int id) {
		// TODO Auto-generated method stub
		try
		{
			
			@SuppressWarnings("rawtypes")
			Query query = (Query) sessionFactory.getCurrentSession().createQuery("update BlogComment where blogId="+id);
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
	public boolean deleteBlogComment(int id) {
		// TODO Auto-generated method stub
		try
		{
			
			sessionFactory.getCurrentSession().delete(id);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}
}
