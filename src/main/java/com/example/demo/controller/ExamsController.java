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

import com.example.demo.dto.ExamsDTO;
import com.example.demo.service.ExamsService;

@RestController
@RequestMapping("/api/exams")
public class ExamsController {
	@Autowired
	ExamsService examsService;
	
	@PostMapping("/createExams")
	public ResponseEntity<ExamsDTO> createExams(@RequestBody ExamsDTO examsDTO) {
		examsService.createExams(examsDTO);
		return new ResponseEntity<ExamsDTO>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllExams")
	public List<ExamsDTO> getAllExams(){
		return examsService.getAllExams();
	}

}
