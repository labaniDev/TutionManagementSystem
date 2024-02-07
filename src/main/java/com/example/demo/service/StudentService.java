package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	StudentRepo studentRepo;
	
	public void createStudent(StudentDTO studentDTO) {
		
	}

}
