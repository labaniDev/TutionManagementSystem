package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Assignments;

public interface AssignmentsRepo extends CrudRepository<Assignments,Integer>,JpaRepository<Assignments,Integer> {

}
