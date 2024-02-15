package com.example.demo.service;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.TeacherRepo;
@Service
public class CourseService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	TeacherRepo teacherRepo;
	
	public void createCourse(TeacherDTO teacherDTO) {
		Optional<Teacher> teacherOptional=teacherRepo.findById(teacherDTO.getId());
		if(teacherOptional.isPresent()) {
			Teacher teacher=teacherOptional.get();
		}
		
		teacherDTO.getStudents().forEach(std->{
			Optional<Student> student=studentRepo.findById(teacherDTO.getId());
			std.getCourses().stream().forEach(course->{
				if(student.isPresent()) {
					Student students=student.get();
					Course courses=new Course();
					courses.setName(course.getName());
					courses.getStudents().add(students);
					courseRepo.save(courses);
				}
			});
		});
	}
	

}
