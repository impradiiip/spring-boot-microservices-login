package com.tom.mobileapp.securityauthserver.jpa.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.mobileapp.securityauthserver.model.User;
import com.tom.mobileapp.securityauthserver.repository.IUserRepository;
import com.tom.mobileapp.securityauthserver.service.IUserService;

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
	public Optional<User> findByName(String name) {
		return userRepository.findByName(name);
	}

}
