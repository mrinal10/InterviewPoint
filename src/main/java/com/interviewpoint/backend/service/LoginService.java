package com.interviewpoint.backend.service;

import org.springframework.stereotype.Service;

import com.interviewpoint.backend.bean.Credentials;
import com.interviewpoint.backend.util.UserType;

@Service
public class LoginService {
	
	public boolean isValidUser(UserType userType, Credentials creds) {
		System.out.println("inside LoginService");
		return false;
	}
}
