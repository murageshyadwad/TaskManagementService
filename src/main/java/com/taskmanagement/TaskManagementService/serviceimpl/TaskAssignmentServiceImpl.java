package com.taskmanagement.TaskManagementService.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.TaskManagementService.model.Task;
import com.taskmanagement.TaskManagementService.model.Users;
import com.taskmanagement.TaskManagementService.repository.Taskrepository;
import com.taskmanagement.TaskManagementService.repository.Usersrepository;
import com.taskmanagement.TaskManagementService.service.TaskAssignmentService;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

	@Autowired
	Usersrepository userRepo;

	@Autowired
	Taskrepository taskRepo;

	@Override
	public long assignTask(long userid) {
		Users user = null;
		List<Task> tasks = null;
		try {
			tasks = taskRepo.findAll();
			user = userRepo.findById(userid).get();

			if (tasks != null && user!=null) {
				for (Task ts : tasks) {
					
					ts.setAssignedtaskto(user.getUsername());
					ts.setDttaskassigned(new Date());
					ts.setTaskstatus("Assigned");
					taskRepo.save(ts);
					

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userid;

	}
}