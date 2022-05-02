package com.bishal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishal.model.User;
import com.bishal.repo.UserRepo;

@Service
public class UserService {
	 @Autowired
	    private UserRepo userRepository;


	    public List<User> getAllUsers(){

	        List<User> users = new ArrayList<>();
	        userRepository.findAll()
	                .forEach(users::add);
	        return users;

	    }


	    public Optional<User> getUser(Long id){

	        return userRepository.findById(id);
        		
	    }

	    public void addUser(User user) {

	        userRepository.save(user);
	    }

	    public void updateUser(String username, User user) {
	        userRepository.save(user);
	    }


	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

}
