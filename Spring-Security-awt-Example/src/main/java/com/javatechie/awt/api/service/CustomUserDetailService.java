package com.javatechie.awt.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javatechie.awt.api.entity.User;
import com.javatechie.awt.api.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService{
      @Autowired
      private UserRepository userRepo;
     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	 User user=userRepo.findByUserName(username);
    	
    	return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
    }
	}


