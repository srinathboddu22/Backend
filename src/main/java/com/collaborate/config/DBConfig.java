package com.collaborate.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.collaborate.DAO.BlogDAO;
import com.collaborate.DAO.BlogDAOImpl;
import com.collaborate.Model.Blog;

@Configuration
@ComponentScan("com.collaborate")
@EnableTransactionManagement
public class DBConfig {
	
	public DataSource getDataSource() {
		DriverManagerDataSource drivermanagerdatasource = new DriverManagerDataSource();
		drivermanagerdatasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		drivermanagerdatasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		drivermanagerdatasource.setUsername("hr");
		drivermanagerdatasource.setPassword("hr"); 
		System.out.println("Datasource");
		return drivermanagerdatasource;

	}


	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}
	@Bean
      public SessionFactory getSessionFactory()
     {
	LocalSessionFactoryBuilder localsessionFactory = new LocalSessionFactoryBuilder(getDataSource());
	localsessionFactory.addProperties(getHibernateProperties());
	localsessionFactory.addAnnotatedClass(Blog.class);
	System.out.println("Session created");
	return localsessionFactory.buildSessionFactory();
      }

      @Bean
      public HibernateTransactionManager getTransaction(SessionFactory sessionFactory)
      {
    	 	System.out.println("Transaction");
		    return new HibernateTransactionManager(sessionFactory);
      }
 
     @Bean
     public BlogDAO getBlogDAO(SessionFactory sessionFactory)
     {
    	 return new BlogDAOImpl(sessionFactory);
     }
     
}
