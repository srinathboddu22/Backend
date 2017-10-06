package com.collaborate.service;

import java.util.List;

import com.collaborate.Model.BlogPost;

public interface BlogPostService {
	void addBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogs(int approved);
	BlogPost getBlogById(int id);

}
