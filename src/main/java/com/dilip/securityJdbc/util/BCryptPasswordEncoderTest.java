package com.dilip.securityJdbc.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

	public static void main(String[] args) {

	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    
	    System.out.println("encoder:  " + encoder.encode("pass"));
	    System.out.println("encoder:  " + encoder.encode("admin"));

	    if (encoder.matches("abel", "$2a$10$IAz6WzJ314LH1NXq7Rf.dOYPP2uvzk08g.eAl9l4DRG4YsxavEV4W")) {
	      System.out.println("encoder: true");
	    }
	    
	    // This will check if the password is a correct hash obtained from BCryptPasswordEncoder
	    if (encoder.matches("Dilip", "$2a$12$PxAFWbcgZBrq6eLOJ.FWouRtG3GKLPHPThxg94G2iIn3sD4EfPdS6")) {
	    	System.out.println("Password matches");
	    }
	}
	
	public String bCryptPasswordEncode(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
		
	}
}
