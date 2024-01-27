package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Data
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
private String name;
private String created_at;
private String update_at;
}
