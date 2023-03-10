package com.dilip2.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestJpaSecurityApi {
	
	@GetMapping("/dilip")
	public String thoughtOfTheDay() {
		return "<h5>Honesty is the best policy but sometimes it sucks</h5>";
	}
}
