package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String contactno;
	private String address;
	@OneToOne
	@JoinColumn(name="regid",referencedColumnName="id")
	private User user;
	
	@OneToMany
	private List<Classes> classes;
	
	@OneToMany
	private List<Exams> exams;
	
	@OneToMany
	private List<Assignments> assignments;
	
	

}
