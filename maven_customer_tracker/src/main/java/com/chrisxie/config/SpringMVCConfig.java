package com.chrisxie.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "com.chrisxie")
@EnableWebMvc
@PropertySource("classpath:app-config.properties")
@EnableTransactionManagement
public class SpringMVCConfig {

	
	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
		
	}
	
	
	@Bean
	public DataSource dataSource() {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		
		dataSource.setUser(env.getProperty("jdbc.user"));
		
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		dataSource.setInitialPoolSize(getIntValue(env.getProperty("connection.pool.initialPoolSize")));
		
		dataSource.setInitialPoolSize(getIntValue(env.getProperty("connection.pool.minlPoolSize")));
		
		dataSource.setInitialPoolSize(getIntValue(env.getProperty("connection.pool.maxlPoolSize")));
		
		dataSource.setInitialPoolSize(getIntValue(env.getProperty("connection.pool.maxIdleTime")));
		
		return dataSource;
		
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		
		sessionFactory.setPackagesToScan("com.chrisxie");
		
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	public Properties hibernateProperties() {

		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		
		return properties;
	}
	
	
	@Bean
	
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}


	private int getIntValue(String string) {
		
		
		return Integer.parseInt(string);
		
	}
	

}
