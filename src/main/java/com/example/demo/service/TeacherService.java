package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AssignmentsDTO;
import com.example.demo.dto.ClassesDTO;
import com.example.demo.dto.ExamsDTO;
import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.Assignments;
import com.example.demo.entity.Classes;
import com.example.demo.entity.Exams;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.AssignmentsRepo;
import com.example.demo.repository.ClassesRepo;
import com.example.demo.repository.ExamsRepo;
import com.example.demo.repository.TeacherRepo;

@Service
@Transactional
public class TeacherService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TeacherRepo teacherRepo;
	@Autowired
	ClassesRepo classesRepo;
	@Autowired
	ExamsRepo examsRepo;
	@Autowired
	AssignmentsRepo assignmentsRepo;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);
	
	public void createTeacher(TeacherDTO teacherDTO) {
		try {
			LOGGER.debug("Inside CreateTeacher:+"+teacherDTO.toString() );
			Optional<Teacher> teacherOptional=teacherRepo.findById(teacherDTO.getUser().getId());
			if(teacherOptional.isPresent()){
				Teacher exsistingTeacher=teacherOptional.get();
				 List<Classes> classesList = new ArrayList<>();
		            for (ClassesDTO classDTO : teacherDTO.getClasses()){
		                Optional<Classes> classesOptional = classesRepo.findById(classDTO.getId());
		                classesOptional.ifPresent(classesList::add);
		            }
		            List<Exams> examsList=new ArrayList<>();
		            for(ExamsDTO examsDTO : teacherDTO.getExams()){
		            	Optional<Exams> examOptional=examsRepo.findById(examsDTO.getId());
		            	examOptional.ifPresent(examsList::add);
		            }
		            List<Assignments> assignmentList=new ArrayList<>();
		            for(AssignmentsDTO assignmentsDTO :teacherDTO.getAssignments()){
		            	Optional<Assignments> assignmentsOptional=assignmentsRepo.findById(assignmentsDTO.getId());
		            	assignmentsOptional.ifPresent(assignmentList::add);
		            }
		            exsistingTeacher.setClasses(classesList);
		            exsistingTeacher.setExams(examsList);
		            exsistingTeacher.setAssignments(assignmentList);
				teacherRepo.save(exsistingTeacher);
			}
		}catch(Exception ex) {
			 ex.printStackTrace();
    		 LOGGER.debug("Exception in createTeacher:"+ex.getMessage());
		}
		
	}

}
