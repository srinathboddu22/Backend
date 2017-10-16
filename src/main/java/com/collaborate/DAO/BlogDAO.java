package com.collaborate.DAO;

import java.util.List;

import com.collaborate.Model.Blog;

public interface BlogDAO {

	
	public Blog getBlog(int blogId);
	
	public boolean approveBlog(Blog blog);
	public boolean editBlog(int blogId);
	public boolean deleteBlog(int blogId);
	public boolean createNewBlog(Blog blog);
	public List<Blog> getBlogList(String bUserName);
}
