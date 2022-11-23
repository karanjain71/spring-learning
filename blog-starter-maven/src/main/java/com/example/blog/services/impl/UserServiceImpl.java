package com.example.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.blog.payloads.UserDto;
import com.example.blog.repositories.UserRepo;
import com.example.blog.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(UserDto user, Integer index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}

}
