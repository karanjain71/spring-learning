package com.springcore.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.springjdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.springcore.springjdbc.dao")
public class jdbcConfigJava {

	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("G0d@1234");
		
		return ds;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		 JdbcTemplate template = new JdbcTemplate();
		 template.setDataSource(getDataSource());
		 return template;
	}
	
	@Bean("studentDao")
	public StudentDaoImpl getStudentDao() {
		StudentDaoImpl student = new StudentDaoImpl();
		student.setJdbcTemplate(getTemplate());
		return student;
		
	}
}
