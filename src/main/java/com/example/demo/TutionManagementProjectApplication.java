package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutionManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutionManagementProjectApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
//	 @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }

}
