package com.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.BlogDAO;
import com.collaborate.DAO.BlogPostDAO;
import com.collaborate.Model.Blog;
import com.collaborate.Model.BlogPost;

@Service
public class BlogPostServiceImpl implements BlogPostService
{
	@Autowired
	BlogDAO blogDAO;
	
	public void createNewBlog(Blog blog)
	{
		blogDAO.createNewBlog(blog);
	}
	public List<Blog> getBlogList(String bUserName)
	{
		return blogDAO.getBlogList(bUserName);
	}
	public Blog getBlogById(int bid)
	{
		return new Blog();
	}
	public Blog getBlogByName(String bname)
	{
		return new Blog();
	}
	public List<Blog> getBlog() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}