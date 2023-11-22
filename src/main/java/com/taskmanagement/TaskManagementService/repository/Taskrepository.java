package com.taskmanagement.TaskManagementService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanagement.TaskManagementService.model.Task;

@Repository
public interface Taskrepository extends JpaRepository<Task, Long> {

}
