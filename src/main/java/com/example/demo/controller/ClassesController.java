package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClassesDTO;
import com.example.demo.service.ClassesService;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {
	
	@Autowired
	ClassesService classesService;
	
	@PostMapping("/createClasses")
	public ResponseEntity<ClassesDTO> createClasses(@RequestBody ClassesDTO classesDTO) {
		classesService.createClasses(classesDTO);
		return new ResponseEntity<ClassesDTO>(HttpStatus.CREATED);
	}
	@GetMapping("/getAllClasses")
	public List<ClassesDTO> getAllClasses(){
		return classesService.getAllClasses();
	}

}
