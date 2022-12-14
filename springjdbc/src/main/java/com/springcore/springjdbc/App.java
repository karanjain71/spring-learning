package com.springcore.springjdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.springjdbc.dao.StudentDao;
import com.springcore.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App  
{
    public static void main( String[] args )
    {
        System.out.println( "This is the JDBC program start 1" );
        ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfigJava.class);
        StudentDao studentDao = (StudentDao)context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student();
        student.setId(6611);
        student.setName("Sathish Jain Changed");
        student.setCity("California");
        
        int result = studentDao.insert(student);
        System.out.println("Number of records inserted "+ result);
//        List<Map<String, Object>> student = studentDao.getAllStudents();
//        System.out.println("The record is "+ student);
        
    }
}
