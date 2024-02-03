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

import com.example.demo.dto.AssignmentsDTO;
import com.example.demo.service.AssignmentsService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentsController {
	@Autowired
	AssignmentsService assignmentsService;
	
	@PostMapping("/createAssignments")
	public ResponseEntity createAssignments(@RequestBody AssignmentsDTO assignmentsDTO) {
		assignmentsService.createAssignments(assignmentsDTO);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@GetMapping("/getAllAssignments")
	public List<AssignmentsDTO> getAllAssignments(){
		return assignmentsService.getAllAssignments();
	}

}
