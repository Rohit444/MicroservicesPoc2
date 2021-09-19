package com.microservicedemo.java.userservice.userservice.vo;

import com.microservicedemo.java.userservice.userservice.entity.User;

public class ResponseTempletVo {
	private User user;
	private Department department;
	
	public ResponseTempletVo() {
		super();
	}
	public ResponseTempletVo(User user, Department department) {
		super();
		this.user = user;
		this.department = department;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "ResponseTempletVo [user=" + user + ", department=" + department + "]";
	}
	

}
