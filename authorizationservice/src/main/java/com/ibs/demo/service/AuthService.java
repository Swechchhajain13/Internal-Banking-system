package com.ibs.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibs.demo.dto.LoginRequest;
import com.ibs.demo.dto.RegisterRequest;
import com.ibs.demo.dto.ResetRequest;
import com.ibs.demo.exception.UserNotFoundException;
import com.ibs.demo.model.User;
import com.ibs.demo.repository.Userrepository;
import com.ibs.demo.security.JwtProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService {

	@Autowired
	private Userrepository userrepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;

	private String encodePassword(String password) {

		// TODO Auto-generated method stub
		return passwordEncoder.encode(password);
	}

	public AuthenticationResponse login(LoginRequest loginRequest) {
		try {
			Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String authenticationToken = jwtProvider.generateToken(authenticate);
		// UserDetailsServiceImpl userDetailsimpl =
		// (UserDetailsServiceImpl)authenticate.getPrincipal();
		// String currentUser = (String) user.getUsertype();
		// String currentUser = (String) userDetailsimpl.toString();
		String currentUser = (String) authenticate.getName();
		return new AuthenticationResponse(authenticationToken, loginRequest.getUsername(), currentUser);
	} catch (AuthenticationException e) {
		throw new UserNotFoundException("Invalid Credentials");
	}
}

	public void reset(ResetRequest resetRequest) {
		String userName = resetRequest.getUserName();
		/*
		 * String emailid = resetRequest.getEmailid() ; User user =
		 * userrepository.findByEmailid(emailid).get();
		 */

		User user = userrepository.findByUserName(userName)
				.orElseThrow(() -> new UserNotFoundException("For userName " + userName));

		user.setPassword(encodePassword(resetRequest.getPassword()));

		userrepository.save(user);

	}

	public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return Optional.of(principal);
	}

	public void usernamecheck(ResetRequest resetRequest) {
		// TODO Auto-generated method stub
		String userName = resetRequest.getUserName();
		User user = userrepository.findByUserName(userName)
				.orElseThrow(() -> new UserNotFoundException("For userName " + userName));
		log.info("Username Exists");
	}

	public void signup(RegisterRequest registerRequest) {
		// TODO Auto-generated method stub
		 User user = new User();
	        
		    user.setName(registerRequest.getName());
	        user.setUserName(registerRequest.getUserName());
	        user.setEmailid(registerRequest.getEmailid());
	         user.setPassword(encodePassword(registerRequest.getPassword()));
	         user.setGender(registerRequest.getGender());
	         user.setDesignation(registerRequest.getDesignation());
	         user.setUsertype(registerRequest.getUsertype());
	         user.setAddress(registerRequest.getAddress());
	         user.setContactno(registerRequest.getContactno());
	         
	         userrepository.save(user);
		
	}

}
