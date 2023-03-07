package com.dilip.securityJdbc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dilip.securityJdbc.model.DchUser;
import com.dilip.securityJdbc.repository.DchUserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	DchUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<DchUser> user = userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ username)); 
			
		return user.map(MyUserDetails::new).get();
	}

}
