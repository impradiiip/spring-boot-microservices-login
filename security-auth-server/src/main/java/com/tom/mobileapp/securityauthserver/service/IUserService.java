package com.tom.mobileapp.securityauthserver.service;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tom.mobileapp.securityauthserver.model.User;

@Repository
public interface IUserService {

	void save(User user);
	
	Optional<User> findByName(String name);
	
	
}
