package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	User user = new User();
	
	@Test
	void testId()
	{
		user.setId(1);;
		assertEquals(user.getId(),1);
	}
	
	@Test
	void testUserName()
	{
		user.setUserName("abc");;
		assertEquals(user.getUserName(),"abc");
	}
	
	@Test
	void testDesignation()
	{
		user.setDesignation("Manager");
		assertEquals(user.getDesignation(),"Manager");
	}
	
	@Test
	void testGender()
	{
		user.setGender("Female");
		assertEquals(user.getGender(),"Female");
	}
	
	@Test
	void testAddress()
	{
		user.setAddress("ABC");
		assertEquals(user.getAddress(),"ABC");
	}
	@Test
	void testContact()
	{
		user.setContactno("123456");
		assertEquals(user.getContactno(),"123456");
	}
	@Test
	void testEmailid()
	{
		user.setEmailid("abc@gmail.com");
		assertEquals(user.getEmailid(),"abc@gmail.com");
	}
	@Test
	void testUsertype()
	{
		user.setUsertype("Manager");
		assertEquals(user.getUsertype(),"Manager");
	}
	
	
	
}
