package com.interviewpoint.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.interviepoint.backend"})
public class InterviewPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPointApplication.class, args);
	}

}
