package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.Userrepository;
import com.example.demo.service.AuthService;

@Service
public class UserService {
	
	@Autowired
    private AuthService authService;
    @Autowired
    private Userrepository userrepository;


    
   /* private UserDto mapFromUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmailid(user.getEmailid());
        userDto.setDesignation(user.getDesignation());
        userDto.setGender(user.getGender());
        userDto.setAddress(user.getAddress());
        userDto.setContactno(user.getContactno());
        return userDto;
    }
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
	public UserDto readSingleUser(Long id) {
        User user = userrepository.findById(id).orElseThrow(() -> new UserNotFoundException("For id " + id));
        return mapFromUserToDto(user);
    }

}