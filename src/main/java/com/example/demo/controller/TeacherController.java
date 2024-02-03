package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/createTeacher")
	public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
		teacherService.createTeacher(teacherDTO);
		return new ResponseEntity<TeacherDTO>(HttpStatus.CREATED);
	}
}
