package com.microservicedemo.java.userservice.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicedemo.java.userservice.userservice.entity.User;
import com.microservicedemo.java.userservice.userservice.service.UserService;
import com.microservicedemo.java.userservice.userservice.vo.ResponseTempletVo;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		logger.info("inside saveUser Controller");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		logger.info("Inside get User by ID service");
		return userService.getUserById(id);
	}
	
	@GetMapping("/userwithDept/{id}")
	public ResponseTempletVo getUserWithDepartment(@PathVariable("id") Long userId) {
		logger.info("Inside get getUserWithDepartment service");
               return userService.getUserWithDepartment(userId);
	}
}
