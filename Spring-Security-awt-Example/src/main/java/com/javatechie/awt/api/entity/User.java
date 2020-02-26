package com.javatechie.awt.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USER_TBL")
@Entity
public class User {
	@Id
	private int id;
	private String userName;
	private String password;
	private String email;

}
