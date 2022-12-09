package com.sts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sts.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByNameStartingWith(String name);
	
	@Query("select u from User u")
	public List<User> getAllUsers();
	
	@Query("select u from User u where u.name=:name")
	public List<User> getUserByName(String name);
	
	@Query(value="select * from User u",nativeQuery=true)
	public List<User> getAllUserSql();
	
	@Query(value="select * from User u where name = :name",nativeQuery=true)
	public List<User> getUserByNameSql(String name);
}

