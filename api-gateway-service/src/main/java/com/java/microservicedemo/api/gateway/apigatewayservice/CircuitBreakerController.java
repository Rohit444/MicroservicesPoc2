package com.java.microservicedemo.api.gateway.apigatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
	
	
	@GetMapping("/fallBackMethodForUser")
	public String fallBackMethodForUser() {
		return "User Service is Down please try after some time !";
	}
	
	@GetMapping("/fallBackMethodForDepartment")
	public String fallBackMethodForDepartment() {
		return "Department Service is Down please try after some time !";
	}
	
	
	
	
	
	

}
