package com.bishal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bishal.model.User;
import com.bishal.service.SecurityService;
import com.bishal.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	   @Autowired
	    private UserService userService;

	    @Autowired
	    private SecurityService securityService;


	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public ResponseEntity<?> addUser(@RequestBody User user){
	        userService.addUser(user);
	        securityService.autologin(user.getUsername(), user.getPassword());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ResponseEntity<?> loginUser(@RequestBody User user){
	        boolean ans = securityService.loginUser(user.getUsername(), user.getPassword());
	        if (!ans)
	            return new ResponseEntity<>("Password incorrect or user does not exist", HttpStatus.FORBIDDEN);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }


	    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
	    public ResponseEntity<?> getCurrentUser() {
	        User user = securityService.getAuthenticatedUser();
	        return new ResponseEntity<Object>(user, HttpStatus.OK);
	    }

	    @RequestMapping("/users")
	    public List<User> getAllUsers(){
	        return  userService.getAllUsers();
	    }

	    @RequestMapping("/users/user")
	    public Optional<User> getUser(){
	        User user = securityService.getAuthenticatedUser();
	        return  userService.getUser(user.getId());
	        		
	        		
	    }


	    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}")
	    public void updateUser(@RequestBody User user, @PathVariable String username){
	         userService.updateUser(username, user);
	    }

	    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}")
	    public void  deleteUser(@PathVariable Long id){
	         userService.deleteUser(id);
	    }

}
