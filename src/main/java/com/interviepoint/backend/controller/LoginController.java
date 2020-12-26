package com.interviepoint.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewpoint.backend.bean.Credentials;
import com.interviewpoint.backend.service.LoginService;
import com.interviewpoint.backend.util.UserType;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(consumes = "application/json", 
				 produces = "application/json", 
				 value = "/user")
	public Boolean userLogin() {//@RequestBody Credentials userCredentials) {
		//return loginService.isValidUser(UserType.user, userCredentials);
		System.out.println("Hello");
		return false;
	}

	@PostMapping(consumes = "application/json", 
				 produces = "application/json", 
				 value = "/interviewer")
	public Boolean interviewerLogin(@RequestBody Credentials interviewerCredentials) {
		return loginService.isValidUser(UserType.interviewer, interviewerCredentials);
	}

	@PostMapping(consumes = "application/json", 
				 produces = "application/json", 
				 value = "/admin")
	public Boolean adminLogin(@RequestBody Credentials adminCredentials) {
		return loginService.isValidUser(UserType.admin, adminCredentials);
	}

}
