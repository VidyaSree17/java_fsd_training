package com.tcs.ReservationManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ReservationManagementSystem.bean.User;
import com.tcs.ReservationManagementSystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;
	
	 @PostMapping
	 public User createUser(@RequestBody User user) {
	     return service.createUser(user);
	 }
	
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<User> getById(@PathVariable String id){
		User user=service.getUser(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
