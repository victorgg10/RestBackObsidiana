package org.obisidiana.app.controller;

import java.util.List;

import org.obisidiana.app.entity.User;
import org.obisidiana.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	IUserService userService;
	
	@GetMapping()
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getAllUserById(@PathVariable("id") long idUser){
		try {
			return new ResponseEntity<User>(userService.getUserById(idUser), HttpStatus.OK);
		} catch(IllegalStateException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> setNewUser(@RequestBody User user){
		try {
			return new ResponseEntity<User>(userService.setUser(user), HttpStatus.CREATED);
		} catch(IllegalStateException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
		
	}
	
}
