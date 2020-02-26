package com.javatechie.awt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.javatechie.awt.api.entity.User;
import com.javatechie.awt.api.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityAwtExampleApplication extends SpringBootServletInitializer {

	@Autowired
	private UserRepository repo;

	@PostConstruct
	void initUsers() {

		List<User> users = Stream.of(new User(101, "javatechie", "password", "javatechie"),
				new User(102, "user1", "pwd1", "user1@gmail.com"), new User(103, "user2", "pwd2", "user2@gmail.com"),
				new User(104, "user3", "pwd3", "user3@gmail.com")).collect(Collectors.toList());
		repo.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAwtExampleApplication.class, args);
		System.out.println("................Now I just updated the file and Saved it........");
		System.out.println("..............I just updated the file from github and saved it.....");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(SpringSecurityAwtExampleApplication.class);
	}

}
