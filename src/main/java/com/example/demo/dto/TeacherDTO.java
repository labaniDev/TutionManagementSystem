package com.example.demo.dto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TeacherDTO {
	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private Long phno;
	private UserDTO user;
	
	private List<ClassesDTO> classes;
	private List<ExamsDTO> exams;
	private List<AssignmentsDTO> assignments;

}
