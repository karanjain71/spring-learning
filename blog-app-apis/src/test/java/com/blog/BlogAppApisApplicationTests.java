package com.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.User;
import com.blog.repositories.UserRepository;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepository userRepository;
	private JpaRepository<User, Integer> jpaRepository;
	
	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testingClasses() {
//		String className = userRepository.getClass().getName();
//		String packageName = userRepository.getClass().getPackageName();
//		
//		String jpaPackageName = jpaRepository.getClass().getPackageName();
//		
//		System.out.println("class is "+ className);
//		System.out.println("package is " + packageName);
//		
//		System.out.println("jpa package is " + jpaPackageName);
//	}

}
