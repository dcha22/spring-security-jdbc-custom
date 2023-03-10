package com.dilip.securityJdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// To scan other packages which are not in the base package
// as this class, add below to includes all the pkgs we want to be scanned
@ComponentScan(basePackages = {"com.dilip.securityJdbc","com.dilip2.rest.controller"})
public class SpringSecurityJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcApplication.class, args);
	}

}
