package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/user")
	
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		userService.saveUser(userDTO);
		return new ResponseEntity<UserDTO>(HttpStatus.CREATED);
	}
	@GetMapping("/getAllUser")
	public List<UserDTO> getAllUser(){
		return userService.getAllUser();
		
	}
	@GetMapping("/getUserByRegid/{regid}")
	public UserDTO getUserById(@PathVariable("regid") Integer regid) {
		return userService.getUserById(regid);
	}
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody UserDTO userDTO) {
		userService.updateUser(userDTO);
		return "User Successfully Updated";
	}
	@DeleteMapping("/deleteUser/{regid}")
	public String deleteUser(@PathVariable("regid")Integer regid) {
		userService.deleteUser(regid);
		return "User Successfully Deleted";
		
	}
}
