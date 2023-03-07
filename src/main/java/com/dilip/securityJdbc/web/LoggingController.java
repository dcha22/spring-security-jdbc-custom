package com.dilip.securityJdbc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	Logger logger  = LoggerFactory.getLogger(LoggingController.class);
	
	@GetMapping("/logging")
	public String logging() {
		logger.trace("A TRACE msg...");
		logger.debug("A DEBUG msg...");
		logger.info("An INFO msg...");
		logger.warn("A WARN msg...");
		logger.error("A ERROR msg...");
		
		return "hello there...";
	}
}
