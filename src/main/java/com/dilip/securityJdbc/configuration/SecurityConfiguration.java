package com.dilip.securityJdbc.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;

import com.dilip.securityJdbc.service.MyUserDetailsService;

@Configuration
public class SecurityConfiguration {

	/*
	 * This configuration class implements security using  
	 * a custom table defined in **.modle.DchUser.java (table: "dch_user")
	 * 
	 * For the custom table you need to implement the UserDetailService 
	 * interface
	 * 
	 * NOTE: To test this, uncomment the class level annotation '@Configuration'
	 *
	 */
	@Autowired
	DataSource dataSource;
	
	@Autowired
	MyUserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	@Autowired
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return (
				// order of the roles is important
				http.authorizeHttpRequests((authz)-> {
					authz.requestMatchers("/").permitAll()
					.requestMatchers("/greeting").permitAll()
					.requestMatchers("/user").hasAnyRole("USER","ADMIN")
					.requestMatchers("/admin").hasRole("ADMIN")
					.requestMatchers("/**").hasAnyRole("ADMIN", "USER")					
					.anyRequest().authenticated()
					;
				})
				.csrf().disable()
				.exceptionHandling().and()
				.formLogin().and() 
				.build()
				);
	}
}
