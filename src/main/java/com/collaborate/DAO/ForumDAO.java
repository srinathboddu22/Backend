package com.collaborate.DAO;

import java.util.List;

import com.collaborate.Model.Blog;
import com.collaborate.Model.Forum;

public interface ForumDAO {

	public boolean createForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getForum();
	public boolean approveForum(Forum forum);
	public boolean editForum(int forumId);
	public boolean deleteForum(int forumId);
}
