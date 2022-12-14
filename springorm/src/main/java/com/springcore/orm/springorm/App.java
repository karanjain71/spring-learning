package com.springcore.orm.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.orm.dao.StudentDao;
import com.springcore.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        //Student student = new Student(233, "Karan Jain 2", "Kolkata");
        //int result = studentDao.insert(student);
//        Student readResult = studentDao.read(233);
//        System.out.println("done " + readResult.getCity() + " " + readResult.getId() + " " + readResult.getName());
//        studentDao.delete(233);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {        	
        	System.out.println("Press 1 to add new student");
        	System.out.println("Press 2 to display all student");
        	System.out.println("Press 3 to display one student");
        	System.out.println("Press 4 to delete the student");
        	System.out.println("Press 5 to edit the student");
        	System.out.println("Press 6 to exit");
        	
        	try {
        		int input = Integer.parseInt(br.readLine());
        		if(input == 1) {
        			System.out.println("Enter student ID");
        			int id = Integer.parseInt(br.readLine());
        			System.out.println("Enter student name");
        			String name = br.readLine();
        			System.out.println("Enter student city");
        			String city = br.readLine();
        			Student student = new Student(id,name,city);
        			int result = studentDao.insert(student);
        			System.out.println("Data inserted successfully "+ result);
        		}
        		else if (input == 2 ) {
        			List<Student> allStudents = studentDao.readAll();
        			System.out.println("_____________________________________________________");
        			for(Student student: allStudents) {
        				System.out.println(student.getId() + " " + student.getName() + " " + student.getCity());
        				System.out.println("_____________________________________________________");
        			}
        		}
				else if (input == 3 ) {
					System.out.println("Enter student ID");
					int studentId = Integer.parseInt(br.readLine());
					Student student = studentDao.read(studentId);
					System.out.println("_____________________________________________________");
					System.out.println("The student details are : " + student.getId() + " " + student.getName() + " " + student.getCity());
					System.out.println("_____________________________________________________");
					System.out.println("Data deleted successfully for student ID"+ studentId);
				}
				else if (input == 4 ) {
					System.out.println("Enter student ID");
					int studentId = Integer.parseInt(br.readLine());
					studentDao.delete(studentId);
				}
				else if (input == 5 ) {
					System.out.println("Enter student ID");
        			int id = Integer.parseInt(br.readLine());
        			System.out.println("Enter student name");
        			String name = br.readLine();
        			System.out.println("Enter student city");
        			String city = br.readLine();
        			Student student = new Student(id,name,city);
        			studentDao.update(student);
				}
				else if (input == 6 ) {
					break;
				}
        		
        	}
        	catch(Exception e){
        		System.out.println("Invalid input, try with another one "+ e.getMessage());
        	}
        }

    	System.out.println("Thank you for using our application");
    	System.out.println("See you next time");
    }
}
