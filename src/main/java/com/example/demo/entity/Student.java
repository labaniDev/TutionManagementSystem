package com.example.demo.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="student")
public class Student {
	
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
    @JoinColumn(name = "student_id")
    private List<Classes> classes;
	
	@OneToMany
    @JoinColumn(name = "student_id")
    private List<Exams> exams;
	
	@OneToMany
    @JoinColumn(name = "student_id")
    private List<Assignments> assignments;
	
	@ManyToMany(mappedBy = "students",cascade = {
	        CascadeType.ALL
	    },fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Teacher> teachers = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
	        CascadeType.ALL
	    })
	@JoinTable(name="student_course", joinColumns = { @JoinColumn(name = "studentid")}, inverseJoinColumns = { @JoinColumn(name = "courseid")})
	private Set<Course> courses = new HashSet<Course>();

}
