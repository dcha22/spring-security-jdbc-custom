package com.dilip.securityJdbc;

import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringSecurityJdbcApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringSecurityJdbcApplicationTests.class);
	
	// Set it to be static so that it's instantiated once per class
	private static RestTemplate restTemplate;
	
    int randomServerPort = 8080;
	
	@BeforeAll
	public static void setup() {
		//this.restTemplate = new RestTemplate();
		if(restTemplate == null) 
			restTemplate = new RestTemplate();
		
		logger.info("Setting up the test class....");
	}
	
	@Test
	void contextLoads() {
		Assertions.assertEquals("DILIP", "DILIP");
	}
	
	@Test
	public void testGreetingApi() throws Exception{
		String baseURL = "http://localhost:"+ randomServerPort+ "/greeting";
		URI uri = new URI(baseURL);
		
		HttpHeaders header =  new HttpHeaders();
		
		header.add("Content-Type", "application/json");
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		Assertions.assertEquals(200, response.getStatusCode().value());
	}
	
	@Test
	public void testLoggingApi() throws Exception{
		String baseURL = "http://localhost:"+ randomServerPort+ "/logging";
		URI uri = new URI(baseURL);
		
		HttpHeaders header =  new HttpHeaders();
		
		header.add("Content-Type", "application/json");
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		Assertions.assertEquals(200, response.getStatusCode().value());
		Assertions.assertTrue(response.getBody().contains("Please sign in"));
	}
}
