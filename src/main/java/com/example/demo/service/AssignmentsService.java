package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AssignmentsDTO;
import com.example.demo.entity.Assignments;
import com.example.demo.repository.AssignmentsRepo;

@Service
public class AssignmentsService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	AssignmentsRepo assignmentsRepo;
	
	public void createAssignments(AssignmentsDTO assignmentsDTO) {
		try {
		Assignments assignments=modelMapper.map(assignmentsDTO, Assignments.class);
		assignmentsRepo.save(assignments);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<AssignmentsDTO> getAllAssignments(){
	  try {
		  List<Assignments> assignmentsList=assignmentsRepo.findAll();
		  List<AssignmentsDTO> assignmentDTOList=modelMapper.map(assignmentsList, new TypeToken<List<AssignmentsDTO>>() {
			}.getType());
			return assignmentDTOList;
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
	return null;
	}

}
