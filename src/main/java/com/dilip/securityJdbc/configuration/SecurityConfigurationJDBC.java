package com.dilip.securityJdbc.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dilip.securityJdbc.service.MyUserDetailsService;


//@Configuration
public class SecurityConfigurationJDBC {

	@Autowired
	DataSource dataSource;

	@Autowired
	MyUserDetailsService userDetailsService;

	/*
	 * This configuration works with the default tables expected
	 * (using JDBC based authentication) by Spring Security - 
	 * 'users' and 'authorities' (in the database).
	 * 
	 * NOTE: if using the other configuration class, make sure to
	 * comment the @Configuration annotation in this class.
	 */
	

	@Autowired
	public void configureGlobalOLD(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		
		// custom queries below if the tables are custom tables (other that default users and authorities
		/*
		.usersByUsernameQuery("select username, password, enabled from users"
				+ " where username = ?") 
		.authoritiesByUsernameQuery("select username, authority from authorities"
				+ " where username = ?")
		*/
		
		;
		
		// below is needed for H2 DB but we are using MySQL and we have manually 
		// created required rows in there..
		//.withDefaultSchema()
		//.withUser(User.withUsername("user")
		//  .password(passwordEncoder().encode("pass"))
		//  .roles("USER"));
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
					authz
					.requestMatchers("/authenticate").authenticated()
					.requestMatchers("/").permitAll()
					.requestMatchers("/greeting").permitAll()
					//.requestMatchers("/**").hasRole("USER")
					.requestMatchers("/user").hasAnyRole("ADMIN", "USER")
					.requestMatchers("/admin").hasRole("ADMIN")
					.requestMatchers("/**").hasRole("USER")
					.anyRequest().denyAll()
					;
				})
				.csrf().disable()
				.exceptionHandling().and()
				.formLogin().and()
				.build()
				);
	}
}
