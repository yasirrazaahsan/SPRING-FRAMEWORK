package com.javatechie.awt.api.controller;

import org.aspectj.weaver.patterns.ExactAnnotationFieldTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.awt.api.entity.AuthRequest;
import com.javatechie.awt.api.util.JwtUtil;

@RestController
public class WelcomController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authMgr;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to java world !!";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authMgr.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())

			);
		} catch (Exception ex) {
			new Exception("Invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());

	}

}
