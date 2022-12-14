package com.springcore.springjdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springcore.springjdbc.entities.Student;


//this is the implementation class for studentDao
@Component("StudentDao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());
        System.out.println("Number of records inserted "+ result);
		return result;
	}
	
	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int result = this.jdbcTemplate.update(query,student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(Student student) {
		String query = "delete from student where id=?";
		int result = this.jdbcTemplate.update(query, student.getId());
		return result;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Student getStudent(int StudentId) {
		// Selecting single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, StudentId);
		return student;
	}

	public List<Map<String, Object>> getAllStudents() {
		String query = "select * from student";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Map<String, Object>> student = this.jdbcTemplate.queryForList(query);
		for(Map<String,Object> x:  student) {
			for(Map.Entry<String, Object> y: x.entrySet()) {				
				System.out.println(y.getKey()+" : "+y.getValue());
			}
		}
		System.out.println();
		return student;
	}
	
}
