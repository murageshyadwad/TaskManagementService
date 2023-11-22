package com.taskmanagement.TaskManagementService.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskmanagement.TaskManagementService.model.Users;
import com.taskmanagement.TaskManagementService.repository.Usersrepository;
import com.taskmanagement.TaskManagementService.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	Usersrepository userRepo;
	
	

	@Override
	public Long createUser(Users user) {
		long userid = 0;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			// Store encodedPassword in the database
			user.setPassword(encodedPassword);
			userid = userRepo.save(user).getUserid();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userid;
	}

}
