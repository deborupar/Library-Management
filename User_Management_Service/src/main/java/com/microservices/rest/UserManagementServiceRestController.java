package com.microservices.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.entity.Users;
import com.microservices.service.UserServices;

@RestController
@RequestMapping("/ums")
public class UserManagementServiceRestController {
	
	private UserServices userServices;
	
	@Autowired
	UserManagementServiceRestController(UserServices userServices){
		this.userServices = userServices;
	}
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userServices.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable int id) {
		return userServices.getUserById(id);
	}
	
	@GetMapping("/users/username/{username}")
	public Users getUserByUsername(@PathVariable String username) {
		return userServices.getUserByUsername(username);
	}
	
	@GetMapping("/users/status/{status}")
	public List<Users> getUsersByStatus(@PathVariable boolean status) {
		if(status == true)
			return userServices.getActiveUsers();
		else
			return userServices.getInactiveUsers();
	}
	
	@GetMapping("/users/firstname/{firstname}")
	public List<Users> getUsersByFirstName(@PathVariable String firstname) {
		return userServices.getUserByFirstname(firstname);
	}
	
	
	@PostMapping("/users")
	public Users createUser(@RequestBody Users user) {
		return userServices.createNewUserEntry(user);
	}
	
	@PostMapping("/users/update/username")
	public String updateUserName(@RequestBody Map<String , String> request) {
		return userServices.updateUsername(Integer.parseInt(request.get("id")), request.get("username"));
		
	}
	

}
