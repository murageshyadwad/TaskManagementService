package com.taskmanagement.TaskManagementService.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taskmanagement.TaskManagementService.model.Users;
import com.taskmanagement.TaskManagementService.repository.Usersrepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Inject your UserRepository or any other data access mechanism here
	@Autowired
	Usersrepository Repo;
	
	
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user details from the database based on the username
    	
        // Example: UserRepository userRepository.findByUsername(username);

        // For demonstration, creating a dummy user
    	Users user=null;
    	try {
    	
    	user = Repo.findUsersByUsername(username);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	if (user.getUsername().equals(username)) {
            return User.builder()
                    .username(username)
                    .password(user.getPassword()) // Password is "password"
                    .roles(user.getUserrole())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    	
        
    }
}

