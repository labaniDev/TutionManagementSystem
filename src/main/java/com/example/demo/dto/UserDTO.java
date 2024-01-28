package com.example.demo.dto;

import com.example.demo.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private Integer regid;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private Long phno;
	private String username;
	private String password;
	private Role role;

}
