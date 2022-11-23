package com.example.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entities.User;

//this repository is used for managing data in user table. That's it. The rows
 
public interface UserRepo extends JpaRepository<User, Integer> {

}
