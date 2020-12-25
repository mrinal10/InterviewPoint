package com.interviepoint.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewpoint.backend.bean.Credentials;
import com.interviewpoint.backend.bean.Response;

@RestController
@RequestMapping("/login")
public class LoginController {

	@PostMapping(consumes = "application/json", produces = "application/json", value = "/user")
	public Response userLogin(@RequestBody Credentials userCredentials) {
		return null;
	}

	@PostMapping(consumes = "application/json", produces = "application/json", value = "/interviewer")
	public Response interviewerLogin(@RequestBody Credentials interviewerCredentials) {
		return null;
	}

	@PostMapping(consumes = "application/json", produces = "application/json", value = "/admin")
	public Response adminLogin(@RequestBody Credentials adminCredentials) {
		return null;
	}

}
