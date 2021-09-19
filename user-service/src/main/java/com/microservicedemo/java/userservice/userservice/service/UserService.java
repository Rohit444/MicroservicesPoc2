package com.microservicedemo.java.userservice.userservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicedemo.java.userservice.userservice.entity.User;
import com.microservicedemo.java.userservice.userservice.repository.UserRepository;
import com.microservicedemo.java.userservice.userservice.vo.Department;
import com.microservicedemo.java.userservice.userservice.vo.ResponseTempletVo;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		logger.info("Inside save user Service");
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		logger.info("Inside get User by ID service");
		return userRepository.findByUserId(id);
	}

	public ResponseTempletVo getUserWithDepartment(Long userId) {
		logger.info("Inside get User by ID service");
		ResponseTempletVo responseTempletVo = new ResponseTempletVo();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(),
				Department.class);
		responseTempletVo.setUser(user);
		responseTempletVo.setDepartment(department);
		return responseTempletVo;
	}

}
