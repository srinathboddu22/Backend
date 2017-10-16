package com.collaborate.service;

import java.util.List;

import com.collaborate.Model.Forum;

public interface ForumService {
	public void createNewForum(Forum f);
	public List<Forum> getForumList(String UserName);
	public void delete(int fid);
	public List<Forum> getForum();
}
