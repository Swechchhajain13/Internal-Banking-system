package com.ibs.demo.model;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	@NoArgsConstructor
	@Getter
	@Setter
	@Entity 
	@Table(name = "user")
	public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "email_id")
	private String emailid;

	@Column(name = "password")
	private String password;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "user_type")
	private String usertype;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "contact_no")
	private String contactno;

	

}
