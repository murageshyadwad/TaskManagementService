package com.taskmanagement.TaskManagementService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanagement.TaskManagementService.model.Task;

@Service
public interface TaskService {
	
	public long createTask(Task task);
	public Task updateTask(Task task);
	public long deleteTask(long taskid);
	public List<Task> getAllTasks();
	public Task getTaskById(long taskid);
	 

}
