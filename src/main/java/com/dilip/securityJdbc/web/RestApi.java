package com.dilip.securityJdbc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
	
	@GetMapping("/")
	public String hiToAll() {
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
		return "Hello, welcome to ADMIN page!";
	}
	
	@GetMapping("/authenticate")
	public String authenticate() {
		return "Authenticated!";
	}
}
