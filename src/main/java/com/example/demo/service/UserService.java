package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	ModelMapper modelMapper;
	public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)  
	
	public void saveUser(UserDTO userDTO) {
    	try {
    		LOGGER.debug("Inside AddUser:"+userDTO.toString());
		User user=modelMapper.map(userDTO, User.class);
		Role userRole=userDTO.getRole();
		user.setRole(userRole);

		userRepo.save(user);
    	}catch(Exception ex) {
    		 ex.printStackTrace();
    		 LOGGER.debug("Exception in addUser:"+ex.getMessage());
    	}
	}
	public List<UserDTO> getAllUser(){
		try {
		List<User> userList=userRepo.findAll();
		List<UserDTO> userDTOlist=modelMapper.map(userList, new TypeToken<List<UserDTO>>() {
		}.getType());
		return userDTOlist;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public UserDTO getUserById(Integer id) {
		return (userRepo.findById(id).map(user ->modelMapper.map(user, UserDTO.class)).orElse(null));
	}
	
	public String updateUser(UserDTO userDTO) {
		try {
			LOGGER.debug("Inside UpdateUser:"+userDTO.toString());
			Optional<User> userOptional=userRepo.findById(userDTO.getId());
			if(userOptional.isPresent()) {
				User user=userOptional.get();
				user.setFirstname(userDTO.getFirstname());
				user.setLastname(userDTO.getLastname());
				user.setAddress(userDTO.getAddress());
				user.setAge(userDTO.getAge());
				user.setUsername(userDTO.getUsername());
				user.setPassword(userDTO.getPassword());
				user.setRole(userDTO.getRole());
				userRepo.save(user);
				return "update";
			}
		}catch(Exception ex) {
			 ex.printStackTrace();
				LOGGER.error("Exception in add Category::"+ex.getMessage());
		}
		return "not update";
	}
	public String deleteUser(Integer id) {
		Optional<User> userOptional=userRepo.findById(id);
		if(userOptional.isPresent()) {
			userRepo.deleteById(id);
			return "User Successfully Deleted";
			
		}
		return "User not deleted";
	}
	

}
