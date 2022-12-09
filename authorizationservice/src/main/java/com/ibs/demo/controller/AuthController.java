package com.ibs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibs.demo.dto.LoginRequest;
import com.ibs.demo.dto.RegisterRequest;
import com.ibs.demo.dto.ResetRequest;
import com.ibs.demo.dto.UserDto;
import com.ibs.demo.security.UserService;
import com.ibs.demo.service.AuthService;
import com.ibs.demo.service.AuthenticationResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author SWECHCHHA
 */

@Slf4j
@RestController
@RequestMapping("/api/auth")

public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        log.info("Inside Signup : ");
        return new ResponseEntity(HttpStatus.OK);
    }

	/**
	 * authenticates the user
	 * 
	 * @param userModel
	 * @return JwtToken
	 * @throws UnauthorizedException
	 */
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		log.info("Inside Login : ");
		return authService.login(loginRequest);
	}

	/*
	 * @GetMapping("/get/{id}") public ResponseEntity<UserDto>
	 * getSingleUser(@PathVariable Long id) { return new
	 * ResponseEntity<>(userService.readSingleUser(id), HttpStatus.OK); } }
	 */
	
	/**
	 * get user details
	 * 
	 * @param userName
	 * @return userDetaild
	 * @throws UserNotFoundException
	 */

	@GetMapping("/get/{userName}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable String userName) {
		log.info("Inside View User Details : ");
		return new ResponseEntity<>(userService.readSingleUser(userName), HttpStatus.OK);
	}
	/**
	 * reset user password
	 * 
	 * @param userName
	 * 
	 * 
	 */

	@PutMapping("/reset")
	public ResponseEntity reset(@RequestBody ResetRequest resetRequest) {
		authService.reset(resetRequest);
		log.info("Inside Password Reset : ");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * verify userName
	 * 
	 * @param userName
	 *
	 * @throws UserNotFoundException
	 */

	@PostMapping("/usernamecheck")
	public ResponseEntity usernamecheck(@RequestBody ResetRequest resetRequest) {
		authService.usernamecheck(resetRequest);
		log.info("Inside usernamecheck : ");
		return new ResponseEntity(HttpStatus.OK);
	}

}
