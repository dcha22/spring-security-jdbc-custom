This project demonstrates how to setup Spring security with JDBC and JPA
 
This version uses SpringBoot 3.x version and Security with SecruityChainFilter

This project implements Spring security with the default tables as well 
the custom table (using JPA)

Default Tables: users and authorities
Custom Table: dch_user

To Use the default tables (Spring security default tables), enable the 
security configuration class - com.dilip.securityJdbc.configuration.SecurityConfigurationDJDBC.java

For the JPA implementation, the password should be encoded password as the bean here expects
encrypted password:

	@Bean
	@Autowired
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); <== this is why you need encoded password in the database
	}
	
For password (Bcrypt encrypted hash), use this link to get one for the given string:
https://bcrypt-generator.com/