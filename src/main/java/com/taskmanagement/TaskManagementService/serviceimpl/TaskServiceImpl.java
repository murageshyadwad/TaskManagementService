package com.taskmanagement.TaskManagementService.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.taskmanagement.TaskManagementService.model.Task;
import com.taskmanagement.TaskManagementService.repository.Taskrepository;
import com.taskmanagement.TaskManagementService.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	Taskrepository taskRepo;

	@Override
	public long createTask(Task task) {
		long taskid = 0;
		try {
			taskid = taskRepo.save(task).getTaskid();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return taskid;
	}

	@Override

	public Task updateTask(Task task) {
		
		Task task1=null;
		Task result = null;
		try {
			task1 = taskRepo.findById(task.getTaskid()).get();
			if (task1!=null){

				task1.setTask(task.getTask());
				task1.setAssignedtaskto(task.getAssignedtaskto());
				task1.setTaskstatus(task.getTaskstatus());
				task1.setDttaskassigned(task.getDttaskassigned());
				task1.setTaskdescription(task.getTaskdescription());
			}

			result = taskRepo.save(task1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	@CacheEvict(value = "task", key = "#taskid")
	public long deleteTask(long taskid) {
		try {
			taskRepo.deleteById(taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskid;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> res = null;
		try {
			res = taskRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	@Cacheable(cacheNames = "myCache" ,key = "#taskid") 
	//When we call get method for second time it will not got db.it will fetch from cache
	public Task getTaskById(long taskid) {
		Task task = null;
		try {
			 task = taskRepo.findById(taskid).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return task;
	}

}
