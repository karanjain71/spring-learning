package com.sts;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sts.dao.UserRepository;
import com.sts.entities.User;

@SpringBootApplication
public class FirststsbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirststsbootApplication.class, args);
		UserRepository userRepository = (UserRepository)context.getBean(UserRepository.class);
//		User user = new User();
//		user.setName("Deepak Jain");
//		user.setCity("Kolkata");
//		user.setStatus("Active");
//		
//		User user1 = new User();
//		user1.setName("Karan Jain");
//		user1.setCity("Kolkata");
//		user1.setStatus("Active");
//		
//		User user2 = new User();
//		user2.setName("Sonu Jain");
//		user2.setCity("Kolkata");
//		user2.setStatus("Active");
		
		//This is for saving one user in the database
		//User resultUser = userRepository.save(user1);
		
//		List<User> users = List.of(user1,user2);
//		//This is for saving multiple users in the db
//		Iterable<User> resultUsers = userRepository.saveAll(users);
//		resultUsers.forEach(user->{
//			System.out.println(user);
//		});
		
//		Update the user of Id 53
//		Optional<User> optional = userRepository.findById(53);
//		User user = optional.get();
//		System.out.println(user);
//		user.setName("Pari Jain");
//		User result = userRepository.save(user);
//		System.out.println(result);
		
//		Deleting the user element
//		userRepository.deleteById(52);
		
//		Delete multiple users
//		Iterable<User> allUsers = userRepository.findAll();
//		allUsers.forEach(user->System.out.println(user));
//		userRepository.deleteAll(allUsers);
//		System.out.println("Deleted");
		
		List<User> usersResult = userRepository.getUserByNameSql("Karan Jain");
		usersResult.forEach(user->System.out.println(user));
		 
		
		
		
	}

}
