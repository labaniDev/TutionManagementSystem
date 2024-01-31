package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Auth;


public interface AuthRepo extends CrudRepository<Integer,Auth>,JpaRepository<Integer,Auth> {
	Optional<Auth> findByUsername(String username);
	Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
