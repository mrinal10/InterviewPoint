package com.interviewpoint.backend.controller;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interviepoint.backend.controller.LoginController;
import com.interviewpoint.backend.bean.Credentials;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LoginController.class)
@ContextConfiguration
@WebAppConfiguration
@EnableWebMvc
public class LoginControllerTest {
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	
	private void testLogin(String uri) throws Exception {
		Credentials creds = new Credentials();
		creds.setUserName("uName");
		creds.setPassWord("pWord");
		String inputJson = mapToJson(creds);
		
		setUp();
		

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(uri)
													.content(inputJson)
													.accept(MediaType.APPLICATION_JSON)
													.contentType(MediaType.APPLICATION_JSON);
		
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void userLoginTest() throws Exception {
		String uri = "/login/user";
		testLogin(uri);
	}
	
	@Test
	public void interviewerLoginTest() throws Exception {
		String uri = "/login/interviewer";
		testLogin(uri);
	}
	
	@Test
	public void adminLoginTest() throws Exception {
		String uri = "/login/admin";
		testLogin(uri);
	}
}
