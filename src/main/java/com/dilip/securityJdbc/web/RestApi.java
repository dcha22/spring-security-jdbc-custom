package com.dilip.securityJdbc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
	
	Logger logger = LoggerFactory.getLogger(RestApi.class);
	
	@GetMapping("/")
	public String hiToAll() {
		logger.info("calling root api..");
		logger.trace("TRACE: Calling root api..");
		return ("<h3>Hello all..</h3>");
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return ("<h3>Hello from Spring Simple Security - all users</h3>");
	}
	
	@GetMapping("/user")
	public String hiToUserRole() {
		return ("<h3>Hello Users</h3>");
	}
	
	@GetMapping("/admin")
	public String sayingHello() {
		return ("<h3>Hello, welcome to ADMIN page!<h3>");
	}
	
	@GetMapping("/authenticate")
	public String authenticate() {
		return "Authenticated!";
	}
}
