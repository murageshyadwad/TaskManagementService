package com.taskmanagement.TaskManagementService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.TaskManagementService.service.TaskAssignmentService;

@RestController
public class TaskAssignmentController {
	
	@Autowired
	TaskAssignmentService assignService;
	
	
	@RequestMapping(value = "/AssignTask/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> getTask(@PathVariable long userid) {
		ResponseEntity<?> response = null;

		try {

		 long userid1 = assignService.assignTask(userid);
			response = new ResponseEntity<>("Tasks Assigned to userid: " + userid1, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

		}
		return response;
	}


}
