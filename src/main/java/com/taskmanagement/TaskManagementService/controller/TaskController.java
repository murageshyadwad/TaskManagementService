package com.taskmanagement.TaskManagementService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.TaskManagementService.model.Task;
import com.taskmanagement.TaskManagementService.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/Task/Save", method = RequestMethod.POST)
	public ResponseEntity<?> saveTask(@RequestBody Task task) {
		ResponseEntity<?> response = null;

		try {

			long taskid = taskService.createTask(task);
			response = new ResponseEntity<>("Task Saved Successfully. Taskid : " + taskid, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

		}
		return response;
	}

	@RequestMapping(value = "/Task/Update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@RequestBody Task task) {
		ResponseEntity<?> response = null;

		try {

			Task updatedTask = taskService.updateTask(task);
			response = new ResponseEntity<>(
					"Task Details Updated Successfully Updated Taskid is :" + updatedTask.getTaskid(), HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

		}
		return response;
	}

	@RequestMapping(value = "/Task/DeleteTask/{taskid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeTask(@PathVariable long taskid) {
		ResponseEntity<?> response = null;

		try {

			long id = taskService.deleteTask(taskid);
			response = new ResponseEntity<>("Removed Task  Successfully. Taskid is: " + id, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

		}
		return response;
	}

	@RequestMapping(value = "/Task/GetTasks", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getTasks() {
		ResponseEntity<?> response = null;

		try {

			List<Task> tasks = taskService.getAllTasks();
			response = new ResponseEntity<>(tasks, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

		}
		return response;
	}
	
	@RequestMapping(value = "/Task/GetTask/{taskid}", method = RequestMethod.GET)
	public ResponseEntity<?> getTask(@PathVariable long taskid) {
		ResponseEntity<?> response = null;

		try {

			Task task = taskService.getTaskById(taskid);
			response = new ResponseEntity<>(task, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

		}
		return response;
	}

}
