package com.collaborate.DAO;

import java.util.List;


import com.collaborate.Model.BlogComment;

public interface BlogCommentDao {

	public boolean createBlog(BlogComment blogcomment);
	public BlogComment getBlogcommentdetails(int id);
	public List<BlogComment> getBlogComment();
    public boolean editBlogComment(int id);
	public boolean deleteBlogComment(int id);
}
