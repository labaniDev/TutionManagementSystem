package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AssignmentsDTO;
import com.example.demo.dto.ClassesDTO;
import com.example.demo.dto.ExamsDTO;
import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.Assignments;
import com.example.demo.entity.Classes;
import com.example.demo.entity.Exams;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.AssignmentsRepo;
import com.example.demo.repository.ClassesRepo;
import com.example.demo.repository.ExamsRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.TeacherRepo;
@Service
public class StudentService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	TeacherRepo teacherRepo;
	@Autowired
	ClassesRepo classesRepo;
	@Autowired
	ExamsRepo examsRepo;
	@Autowired
	AssignmentsRepo assignmentsRepo;
	
	public void createStudent(TeacherDTO teacherDTO) {
		Optional<Teacher> teacher=teacherRepo.findById(teacherDTO.getId());
		if(teacher.isPresent()) {
			List<Student> students=modelMapper.map(teacherDTO.getStudents(),new TypeToken<List<Student>>()  {}.getType());
			
			students.stream().forEach(std->{
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
			            std.setClasses(classesList);
			            std.setExams(examsList);
			            std.setAssignments(assignmentList);
			            studentRepo.save(std);
				}
				
			);}
			
		}
	}


