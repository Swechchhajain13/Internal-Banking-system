package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.UserDto;
import com.example.demo.security.UserService;
import com.example.demo.service.AuthService;
import com.example.demo.service.AuthenticationResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController 
@RequestMapping("/api/auth")

	

	
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private AuthService authService;
	
	
	@PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		log.info("Inside Login : ");
        return authService.login(loginRequest);
    }

	
	   @GetMapping("/get/{id}")
	    public ResponseEntity<UserDto> getSingleUser(@PathVariable @RequestBody Long id) {
	        return new ResponseEntity<>(userService.readSingleUser(id), HttpStatus.OK);
	    }
	}