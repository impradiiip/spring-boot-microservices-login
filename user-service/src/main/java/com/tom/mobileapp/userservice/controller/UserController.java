package com.tom.mobileapp.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tom.mobileapp.userservice.jpa.service.UserService;
import com.tom.mobileapp.userservice.model.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save/user")
	public String saveUser(@RequestBody User user) {
		userService.save(user);
		return "user saved successfully";
	}

	@GetMapping("/get/user")
	public User getUser(@RequestParam String name) {
		return userService.findByName(name);
	}

}
