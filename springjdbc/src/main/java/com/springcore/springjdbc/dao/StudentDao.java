package com.springcore.springjdbc.dao;

import java.util.List;
import java.util.Map;

import com.springcore.springjdbc.entities.Student;

//This class will contain all the methods that will contain the query to the db
public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(Student student);
	public Student getStudent(int StudentId);
	public List<Map<String, Object>> getAllStudents();
	
}
