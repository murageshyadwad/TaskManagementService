package com.taskmanagement.TaskManagementService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.TaskManagementService.model.Users;
import com.taskmanagement.TaskManagementService.service.UsersService;


@RestController
public class UsersController {
	
	@Autowired
	UsersService userService;
	
	@PostMapping("/Users/Save")
	public ResponseEntity<?> saveEmployee(@RequestBody Users user) {
		ResponseEntity<?> response = null;

		try {

			Long userid = userService.createUser(user);
			response = new ResponseEntity<>("New User Saved. Userid : " + userid, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(0, HttpStatus.OK);

		}
		return response;
	}

}
