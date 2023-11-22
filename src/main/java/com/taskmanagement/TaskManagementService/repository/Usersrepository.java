package com.taskmanagement.TaskManagementService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanagement.TaskManagementService.model.Users;

@Repository
public interface Usersrepository extends JpaRepository<Users, Long> {

	

	Users findUsersByUsername(String username);

}
