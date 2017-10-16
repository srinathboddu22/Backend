package com.collaborate.service;

import java.util.List;

import com.collaborate.Model.Blog;
import com.collaborate.Model.BlogPost;

public interface BlogPostService {
	/*
	 void addBlogPost(BlogPost blogPost);
	 
	List<BlogPost> getBlogs(int approved);
	BlogPost getBlogById(int id);
*/
	
	public void createNewBlog(Blog blog);
	public List<Blog> getBlogList(String bUserName);
	public Blog getBlogById(int bid);
	public Blog getBlogByName(String bname);
	public List<Blog> getBlog();
	
}
