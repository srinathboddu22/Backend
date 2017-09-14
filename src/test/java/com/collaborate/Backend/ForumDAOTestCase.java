package com.collaborate.Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.collaborate.DAO.ForumDAO;
import com.collaborate.Model.Forum;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
public class ForumDAOTestCase {
	static ForumDAO forumDAO;
	static Forum forum;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.collaborate");
		annotationConfigAppContext.refresh();
		forumDAO=(ForumDAO)annotationConfigAppContext.getBean("forumDAO");
	    forum=(Forum)annotationConfigAppContext.getBean("forum");
	}
	
	@Test
	public void createForumtest()
	{
		//Forum forum=new Forum();
		forum.setForumId(111);
		forum.setForumName("Dravid");
		forum.setForumContent("Dravid is a Cricket Coach");
		
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		
		assertTrue("Problem in Forum Creation",forumDAO.createForum(forum));
	
	}
	
	
	@Test
	public void editForumTest()
	{
	Forum forum = new Forum();
	forum.setForumId(111);
	forum.setForumName("Dravid");
	forum.setForumContent("Dravid plays Cricket ");
	forum.setCreateDate(new java.util.Date());
	forum.setUserId(1001);
	forum.setStatus("NA");
	assertTrue("Problem in approving forum",forumDAO.editForum(forum.getForumId()));	
	}
	

	@Test
	public void deleteForumTest()
	{
	Forum forum = new Forum();
	forum.setForumId(111);
	assertTrue("Problem in approving Forum",forumDAO.deleteForum(forum.getForumId()));	
	}
	
	@Ignore
	@Test
	public void getForumTest()
	{
	Forum forum = new Forum();
	forum.setForumId(111);
	}
	@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum=new Forum();
		forum.setForumId(111);
		forum.setForumName("Dravid");
		forum.setForumContent("Dravid is a Cricket Coach");
		forum.setUserId(1001);
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		assertTrue("Problem in approving Forum",forumDAO.approveForum(forum));	
	}
}
