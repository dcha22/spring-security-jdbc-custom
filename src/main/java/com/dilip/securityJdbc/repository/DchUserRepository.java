package com.dilip.securityJdbc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilip.securityJdbc.model.DchUser;

public interface DchUserRepository extends JpaRepository<DchUser, Long> {
	Optional<DchUser> findByUserName(String username);
}
