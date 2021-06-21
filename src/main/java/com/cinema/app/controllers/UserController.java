package com.cinema.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.app.entities.User;
import com.cinema.app.services.IUserService;
import com.cinema.app.utils.response.UserResponse;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
		UserResponse userResponse = new UserResponse();
		
		try {
			userResponse = userService.getUser(id);
			return ResponseEntity.ok().body(userResponse);
		} catch (Exception e) {
			userResponse.setStatus(false);
			userResponse.setMessage(UserResponse.GET_USER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<UserResponse> getAllUsers(){
		UserResponse userResponse = new UserResponse();
		
		try {
			userResponse = userService.getAllUsers();
			return ResponseEntity.ok().body(userResponse);
		} catch (Exception e) {
			userResponse.setStatus(false);
			userResponse.setMessage(UserResponse.GET_USER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserResponse> postUser(@RequestBody User user){
		UserResponse userResponse = new UserResponse();
		try {
			userResponse = userService.createUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		} catch (Exception e) {
			userResponse.setStatus(false);
			userResponse.setMessage(UserResponse.POST_USER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse); 
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id){
		UserResponse userResponse = new UserResponse();
		
		try {
			userResponse = userService.deleteUser(id);
			return ResponseEntity.ok().body(userResponse);
		} catch (Exception e) {
			userResponse.setStatus(false);
			userResponse.setMessage(UserResponse.DELETE_USER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<UserResponse> updateUser(@RequestBody User user){
		UserResponse userResponse = new UserResponse();
		try {
			userResponse = userService.updateUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		} catch (Exception e) {
			userResponse.setStatus(false);
			userResponse.setMessage(UserResponse.UPDATE_USER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse); 
		}
	}
}
