package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepo;

@Service
@Transactional
public class TeacherService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TeacherRepo teacherRepo;
	public static final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);
	public void createTeacher(TeacherDTO teacherDTO) {
		try {
			LOGGER.debug("Inside CreateTeacher:+"+teacherDTO.toString() );
			Optional<Teacher> teacherOptional=teacherRepo.findById(teacherDTO.getUser().getRegid());
			if(teacherOptional.isPresent()) {
				Teacher exsistingTeacher=teacherOptional.get();
				exsistingTeacher.setName(teacherDTO.getName());
				exsistingTeacher.setContactno(teacherDTO.getContactno());
				exsistingTeacher.setAddress(teacherDTO.getAddress());
				teacherRepo.save(exsistingTeacher);
			}
			
			
		}catch(Exception ex) {
			 ex.printStackTrace();
    		 LOGGER.debug("Exception in createTeacher:"+ex.getMessage());
		}
		
	}

}
