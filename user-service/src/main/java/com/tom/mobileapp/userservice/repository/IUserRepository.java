package com.tom.mobileapp.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.tom.mobileapp.userservice.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
	
	//User findByRoles(String vv);
	
	
}
