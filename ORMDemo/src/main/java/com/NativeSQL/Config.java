package com.NativeSQL;

import java.util.Properties;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.NativeSQL")
public class Config {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); // db object for connection
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // db driver for sql jar file
		dataSource.setUrl("jdbc:mysql://localhost:3306/Employees"); // url of db table
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource((javax.sql.DataSource) dataSource()); // 1. set the data source
		sessionFactory.setPackagesToScan("com.NativeSQL"); // 2. scan all required components
		sessionFactory.setHibernateProperties(hibernateProperties()); // 3. hibernate properties
		return sessionFactory;
	}

	private Properties hibernateProperties() {

		Properties propobj = new Properties();
		propobj.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // which db using
		propobj.put("hibernate.show_sql", "false"); // shows all the sql queries peforming background by ORM
		propobj.put("hibernate.hbm2ddl.auto", "update");
		return propobj;
	}

}
