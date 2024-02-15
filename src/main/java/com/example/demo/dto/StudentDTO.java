package com.example.demo.dto;
import java.util.List;
import java.util.Set;

import com.example.demo.entity.Assignments;
import com.example.demo.entity.Classes;
import com.example.demo.entity.Exams;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StudentDTO {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private Long phno;
	private UserDTO user;
	
	private List<Classes> classes;
	private List<Exams> exams;
	private List<Assignments> assignments;
	private Set<CourseDTO> courses;


}
