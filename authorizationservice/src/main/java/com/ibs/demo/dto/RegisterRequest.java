package com.ibs.demo.dto;

import javax.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter

public class RegisterRequest {
	
	private long id;

	private String name;
	
	private String userName;

	private String emailid;

	private String password;

	
	private String designation;

	
	private String usertype;

	private String gender;

	private String address;

	private String contactno;

}



