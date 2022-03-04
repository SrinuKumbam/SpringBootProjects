package com.boot.training.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.training.model.RestUser;
import com.boot.training.model.VO.ResponseEntityVO;
import com.boot.training.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "departmentService", fallbackMethod = "serviceFallbackMethod")
	public ResponseEntityVO getUserDetails(@PathVariable Long userId) {
		return userService.getUserDetails(userId);
	}
	
	public String serviceFallbackMethod(Long l, Exception e) {
		return "This is a fallback method for getUserDetails";
	}
	
	@GetMapping()
	public List<RestUser> gettUsers() {
		
		return userService.getUsers();
	}
	
	@PostMapping()
	public String postUsers(@RequestBody RestUser userDetails){		
		userService.saveUser(userDetails);
		return "User Added";
	}
	
	@PutMapping("/{userId}")
	public String putUser(@PathVariable Long userId, @RequestBody RestUser userDetails) {
		
		return userService.updateUser(userId, userDetails);
	}
	
	@DeleteMapping("{id}")
	public String deleteUser(@PathVariable Long id) {		
			return userService.deleteUser(id);
			
	}
	//Consuming RestService by URL
	@GetMapping("/clientcall")
	public List<RestUser> getUsersByUrl(){
		String url = "http://localhost:8080/users";
		RestTemplate template = new RestTemplate();
		List<RestUser> users = (List<RestUser>) template.getForObject(url, Object.class);
		
		return users;
		
	}
	
/*	@GetMapping("{lastName}")
	public List<RestUser> findAllUsersByLastName(@PathVariable String lastName){
		return userService.getAllUsersByLastName(lastName);
	}*/
}
