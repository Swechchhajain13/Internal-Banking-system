package com.ibs.demo.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibs.demo.dto.UserDto;
import com.ibs.demo.exception.UserNotFoundException;
import com.ibs.demo.model.AppliedLoans;
import com.ibs.demo.model.User;
import com.ibs.demo.repository.Userrepository;
import com.ibs.demo.service.AuthService;

@Service
public class UserService {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private Userrepository userrepository;


	/*
	 * private UserDto mapFromUserToDto(User user) { UserDto userDto = new
	 * UserDto(); userDto.setId(user.getId());
	 * userDto.setUserName(user.getUserName());
	 * userDto.setEmailid(user.getEmailid());
	 * userDto.setDesignation(user.getDesignation());
	 * userDto.setGender(user.getGender()); userDto.setAddress(user.getAddress());
	 * userDto.setContactno(user.getContactno()); return userDto; }
	 */

	private UserDto mapFromUserToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUserName(user.getUserName());
		userDto.setEmailid(user.getEmailid());
		userDto.setDesignation(user.getDesignation());
		userDto.setGender(user.getGender());
		userDto.setAddress(user.getAddress());
		userDto.setContactno(user.getContactno());
		userDto.setUsertype(user.getUsertype());
		return userDto;
	}

	@Transactional
	public UserDto readSingleUser(String userName) {
		User user = userrepository.findByUserName(userName)
				.orElseThrow(() -> new UserNotFoundException("For userName " + userName));
		return mapFromUserToDto(user);
	}

	public List<User> getAllUsers() {
		List<User> list = userrepository.findAll();
		System.out.println(list);
		return list;
	}


}
