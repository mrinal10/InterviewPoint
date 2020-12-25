package com.interviewpoint.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.interviepoint.backend.controller.LoginController;

@SpringBootTest
class InterviewPointApplicationTests {

	@Autowired
	private LoginController loginController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(loginController).isNotNull();
	}

}
