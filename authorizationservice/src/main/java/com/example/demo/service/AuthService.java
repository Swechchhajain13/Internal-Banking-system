package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.Userrepository;
import com.example.demo.security.JwtProvider;

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
	        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
	                loginRequest.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authenticate);
	        String authenticationToken = jwtProvider.generateToken(authenticate);
	        return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
	    }
		public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
	        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
	                getContext().getAuthentication().getPrincipal();
	        return Optional.of(principal);
	    }
		
}
