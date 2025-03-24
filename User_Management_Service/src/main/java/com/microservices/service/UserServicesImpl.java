package com.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.dao.UserRepository;
import com.microservices.entity.Users;

import jakarta.transaction.Transactional;

@Service
public class UserServicesImpl implements UserServices {
	
	private UserRepository userRepo;
	
	@Autowired
	UserServicesImpl(UserRepository userRepo){
		this.userRepo = userRepo;
	}

	@Override
	public Users getUserById(int id) {
		Optional<Users> result = userRepo.findById(id);
		if(result.isPresent())
		 return result.get();
		else
			return null;
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Users getUserByUsername(String username) {
//		Users userExample = new Users();
//		userExample.setUsername(username);
//		Example<Users> example = Example.of(userExample);
//		Optional<Users> result = userRepo.findOne(example);
//		if(result.isPresent())
//		 return result.get();
//		else
//			return null;
		return userRepo.getUsersByUsername(username);
	}

	@Override
	public List<Users> getUserByFirstname(String firstname) {
//		ExampleMatcher matcher = ExampleMatcher.matching()
//			    .withIgnoreCase()  // This will make it case-insensitive
//			    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
//		Users userExample = new Users();
//		userExample.setFirst_name(firstname);
//		Example<Users> example = Example.of(userExample , matcher);
//		return userRepo.findAll(example);
		
		return userRepo.getUsersByFirstName(firstname);
	}

	@Override
	public List<Users> getActiveUsers() {
		return userRepo.findActiveUser();
	}

	@Override
	public List<Users> getInactiveUsers() {
//		Users userExample = new Users();
//		userExample.setIs_active(false);
//		Example<Users> example = Example.of(userExample);
//		return userRepo.findAll(example);
		return userRepo.findInactiveUser();
	}

	@Override
	@Transactional
	public Users createNewUserEntry(Users user) {
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public String updateUsername(int id, String username) {
		try {
			Optional<Users> result = userRepo.findById(id);
			if(result.isPresent()) {
				Users user = result.get();
				user.setUsername(username);
				userRepo.save(user);
				return " User with user id "+id+" updated";
			}
			else
				return "No user found with user id "+id;	
		}
		catch(Exception e) {
			return "Failed to update user";
			
		}
	}

	@Override
	@Transactional
	public String updateUserActiveStatus(int id, boolean status) {
		try {
			Optional<Users> result = userRepo.findById(id);
			if(result.isPresent()) {
				Users user = result.get();
				user.setIs_active(status);
				userRepo.save(user);
				return " User with user id "+id+" updated";
			}
			else
				return "No user found with user id "+id;	
		}
		catch(Exception e) {
			return "Failed to update user";
			
		}
	}

	@Override
	@Transactional
	public String deleteById(int id) {
		try {
			 userRepo.deleteById(id);
			 return "Successfully delete user with id "+id;
		}
		catch(Exception e) {
			 return "Unable to delet user with id "+id;
		}
		
	}

	@Override
	@Transactional
	public String deteleByUsername(String username) {
		try {
			userRepo.deteleByUsername(username);
			return "Deleted user with username =  "+username;
		}
		catch(Exception e) {
			return "Unable to delet user with username =  "+username;
		}
	}

}
