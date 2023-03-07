package com.dilip.securityJdbc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="dch_user")
public class DchUser {
		

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String password;
	private String roles;
	private boolean active;
	
}
