package com.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.BlogPostDAO;
import com.collaborate.Model.BlogPost;

@Service
public class BlogPostServiceImpl implements BlogPostService {
@Autowired
private BlogPostDAO blogPostDAO;
public void addBlogPost(BlogPost blogPost){
	blogPostDAO.addBlogPost(blogPost);
}
public List<BlogPost> getBlogs(int approved){
	return blogPostDAO.getBlogs(approved);
}
}
