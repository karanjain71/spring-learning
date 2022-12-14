package com.springcore.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springcore.orm.entities.Student;

public class StudentDao {
	
	//now this 
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Student student) {
		
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
		
	}
	
	//get the single student details....like the read operation
	public Student read(int studentId) {
		Student result = this.hibernateTemplate.get(Student.class, studentId);
		return result;
	}
	
	public List<Student> readAll() {
		List<Student> result = this.hibernateTemplate.loadAll(Student.class);
		return result;
	}
	
	//now we will do the delete operation
	@Transactional
	public void delete(int studentId) {
		this.hibernateTemplate.delete((Student)this.read(studentId));
		System.out.println("Data deleted successfully for student id " + studentId);
	}
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
		System.out.println("Data updated successfully for student id " + student.getId());
	}
}
