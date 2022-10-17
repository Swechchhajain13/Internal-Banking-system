package com.ibs.demo.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
        super(message);
    }

}
