package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Classes;

public interface ClassesRepo extends CrudRepository<Classes,Integer>,JpaRepository<Classes,Integer>{

}
