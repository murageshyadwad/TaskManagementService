package com.taskmanagement.TaskManagementService.service;

import org.springframework.stereotype.Service;

import com.taskmanagement.TaskManagementService.model.Users;

@Service
public interface UsersService {
	
	public Long createUser(Users user);

}
