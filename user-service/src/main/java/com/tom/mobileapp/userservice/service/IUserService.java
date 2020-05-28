package com.tom.mobileapp.userservice.service;

import org.springframework.stereotype.Repository;

import com.tom.mobileapp.userservice.model.User;

@Repository
public interface IUserService {

	void save(User user);
	
	User findByName(String name);
	
	
}
