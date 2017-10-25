package com.collaborate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.collaborate.DAO.BlogPostDao;
import com.collaborate.DAO.BlogPostDaoImpl;
import com.collaborate.DAO.FriendDao;
import com.collaborate.DAO.FriendDaoImpl;
import com.collaborate.DAO.JobDao;
import com.collaborate.DAO.JobDaoImpl;
import com.collaborate.DAO.ProfilePictureDao;
import com.collaborate.DAO.ProfilePictureDaoImpl;
import com.collaborate.DAO.UserDao;
import com.collaborate.DAO.UserDaoImpl;
import com.collaborate.Model.BlogComment;
import com.collaborate.Model.BlogPost;
import com.collaborate.Model.Chat;
import com.collaborate.Model.Friend;
import com.collaborate.Model.Job;
import com.collaborate.Model.ProfilePicture;
import com.collaborate.Model.User;

public class DBConfig

{
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("collab_db");
		dataSource.setPassword("pass");

		System.out.println("DataBase is connected.........!");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClasses(User.class);
		 sessionBuilder.addAnnotatedClasses(Job.class);
		 sessionBuilder.addAnnotatedClasses(BlogPost.class);
		 sessionBuilder.addAnnotatedClasses(BlogComment.class);
		 sessionBuilder.addAnnotatedClasses(Friend.class);
		 sessionBuilder.addAnnotatedClasses(ProfilePicture.class);
		 sessionBuilder.addAnnotatedClasses(Chat.class);
		 System.out.println("Session is created................!");

		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction is crated............!");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="usersDao")
	public UserDao getusersDAO(SessionFactory sessionFactory)
	{
		return new UserDaoImpl();
	}
	@Autowired
	@Bean(name="jobDao")
	public JobDao getjobDAO(SessionFactory sessionFactory){
		
		return new JobDaoImpl();
	}
	@Autowired
	@Bean(name="blogPostDao")
	public BlogPostDao getblogPostDAO(SessionFactory sessionFactory)
	{
		return new BlogPostDaoImpl();
	}

	@Autowired
	@Bean(name="friendDao")
	public FriendDao getfriendDAO(SessionFactory sessionFactory)
	{
		return new FriendDaoImpl();
	}
	@Autowired
	@Bean(name="profilePictureDao")
	public ProfilePictureDao getprofilePictureDAO(SessionFactory sessionFactory)
	{
		return new ProfilePictureDaoImpl();
	}

}