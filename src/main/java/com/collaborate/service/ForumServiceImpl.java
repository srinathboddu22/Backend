package com.collaborate.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.ForumDAOImpl;
import com.collaborate.Model.Forum;

@Service
public class ForumServiceImpl implements ForumService
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	ForumDAOImpl forumDAO;

	public ForumServiceImpl(){}
	
	public ForumServiceImpl(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	public void createNewForum(Forum f) {
		forumDAO.createNewForum(f);
		
	}

	public List<Forum> getForumList(String UserName) {
		
		return forumDAO.getForumList(UserName);
		
	}

	
	public void delete(int fid) {
		forumDAO.delete(fid);
		
	}
	
	public List<Forum> getForum()
	{
		System.out.println("I am in forum service");
		return forumDAO.getForum();
	}

}