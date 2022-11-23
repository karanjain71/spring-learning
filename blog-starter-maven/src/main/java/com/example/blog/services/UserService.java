package com.example.blog.services;

import java.util.List;

import com.example.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer index);
	UserDto getUserId(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	
	

}
