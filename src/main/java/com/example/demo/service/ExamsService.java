package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClassesDTO;
import com.example.demo.dto.ExamsDTO;
import com.example.demo.entity.Exams;
import com.example.demo.repository.ExamsRepo;

@Service
public class ExamsService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	ExamsRepo examsRepo;
	
	public void createExams(ExamsDTO examsDTO) {
			try {
				Exams exams=modelMapper.map(examsDTO, Exams.class);
				examsRepo.save(exams);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	public List<ExamsDTO> getAllExams(){
		try {
		List<Exams> examList=examsRepo.findAll();
		List<ExamsDTO> examDtoList=modelMapper.map(examList, new TypeToken<List<ExamsDTO>>() {
		}.getType());
		return examDtoList;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
