package com.javatechie.awt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.awt.api.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	User findByUserName(String username);

}
