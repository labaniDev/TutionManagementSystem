package com.example.demo.entity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private Long phno;
	@OneToOne
	@JoinColumn(name="regid",referencedColumnName="id")
	private User user;
	
	@OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Classes> classes;
	
	@OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Exams> exams;
	
	
	@OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Assignments> assignments;
	
	

}
