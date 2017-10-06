package com.collaborate.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.Model.BlogPost;

@Repository
@Transactional
public class BlogPostDAOImpl implements BlogPostDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void addBlogPost(BlogPost blogPost){
		Session session=sessionFactory.getCurrentSession();
		session.save(blogPost);
	}

}
