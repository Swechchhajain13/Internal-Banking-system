package com.ibs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.demo.model.User;
import com.ibs.demo.repository.Userrepository;

@Service
public class UsersService {

	@Autowired
	private Userrepository repository;

	
	public User findByEmail(String emailId) {
		return repository.findByEmailId(emailId);
	}
	
	public User findByUserName(String userName) {
		return repository.findByuserName(userName);
	}
}
