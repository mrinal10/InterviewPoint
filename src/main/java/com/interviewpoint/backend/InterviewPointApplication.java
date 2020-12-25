package com.interviewpoint.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.interviewpoint"})
public class InterviewPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPointApplication.class, args);
	}

}
