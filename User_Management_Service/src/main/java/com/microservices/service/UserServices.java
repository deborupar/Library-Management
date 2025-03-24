package com.microservices.service;

import java.util.List;

import com.microservices.entity.Users;

public interface UserServices {
	
	Users getUserById(int id);
	
	List<Users> getAllUsers();
	
	Users getUserByUsername(String username);
	
	List<Users> getUserByFirstname(String firstname);
	
	List<Users> getActiveUsers();
	
	List<Users> getInactiveUsers();
	
	Users createNewUserEntry(Users user);
	
	String updateUsername(int id , String username);
	
	String updateUserActiveStatus(int id , boolean status);
	
	String deleteById(int id);
	
	String deteleByUsername(String username);

}
