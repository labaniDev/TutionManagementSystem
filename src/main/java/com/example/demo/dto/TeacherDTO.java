package com.example.demo.dto;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.Classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {
	private Integer id;
	private String name;
	private String contactno;
	private String address;
	private UserDTO user;
	
	private List<ClassesDTO> classes;
	private List<ExamsDTO> exams;
	private List<AssignmentsDTO> assignments;

}
