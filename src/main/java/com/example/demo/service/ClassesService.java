package com.example.demo.service;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ClassesDTO;
import com.example.demo.entity.Classes;
import com.example.demo.repository.ClassesRepo;
@Service
public class ClassesService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	ClassesRepo classesRepo;
	
	public void createClasses(ClassesDTO classesDTO) {
		Classes classes=modelMapper.map(classesDTO, Classes.class);
		classesRepo.save(classes);
	}


	public List<ClassesDTO> getAllClasses(){
	try {
		List<Classes> classList=classesRepo.findAll();
		List<ClassesDTO> classDtoList=modelMapper.map(classList, new TypeToken<List<ClassesDTO>>() {
		}.getType());
		return classDtoList;
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return null;
}
}
