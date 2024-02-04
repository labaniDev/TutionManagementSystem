package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Exams;

public interface ExamsRepo extends CrudRepository<Exams,Integer>,JpaRepository<Exams,Integer> {

}
