package com.tom.mobileapp.userservice.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.mobileapp.userservice.model.User;
import com.tom.mobileapp.userservice.repository.IUserRepository;
import com.tom.mobileapp.userservice.service.IUserService;



@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	
	
	
	
}
