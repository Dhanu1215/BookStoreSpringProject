package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.dto.LoginDTO;
import com.example.bookstore.dto.ResponseDTO;
import com.example.bookstore.dto.UserDTO;
import com.example.bookstore.model.User;
import com.example.bookstore.service.IUserService;

/**
 * Rest Controller to handle the all rest calls
 * 
 * @RestController : UserController
 * @author praja
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	/**
	 * @Autowired : Marks a constructor, field, setter method, or configure method
	 *            as to be autowired by Spring's dependency injection facilities.
	 */
	@Autowired
	private IUserService userservice;

	/**
	 * Call Get method to handle get call It returns user details
	 * 
	 * @return : Http Status & user details
	 */
	@RequestMapping("/getuser")
	public ResponseEntity<ResponseDTO> getUserDetails() {
		List<User> userList = null;
		userList = userservice.getUserDetails();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", userList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call Get method It returns user details by user Id
	 * 
	 * @param id : user Id
	 * @return : user details
	 */
	@GetMapping("/get/{userId}")
	public ResponseEntity<ResponseDTO> getUserById(@PathVariable("userId") long userId) {
		User user = null;
		user = userservice.getUserById(userId);
		ResponseDTO respDTO = new ResponseDTO("Get user by id call successful", user);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method to add details It creates the user details
	 * 
	 * @param userDTO : user details
	 * @return : details
	 */
	@PostMapping("/adduser")
	public ResponseEntity<ResponseDTO> createUserDetails(@RequestBody UserDTO userDTO) {
		User user = null;
		user = userservice.createUserDetails(userDTO);
		ResponseDTO respDTO = new ResponseDTO("Created user details successfully", user);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call put method to update details It update the user by id.
	 * 
	 * @param userDTO : user details.
	 * @return : details
	 */
	@PutMapping("/update/{userId}")
	public ResponseEntity<ResponseDTO> updateUserDetailsById(@PathVariable("userId") long userId,
			@RequestBody UserDTO userDTO) {
		User user = null;
		user = userservice.updateUserDetailsById(userId, userDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated user details successfully", user);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call delete method to remove user details It delete the cart details by user
	 * id
	 * 
	 * @param id : user id
	 * @return : user id which is deleted
	 */
	@DeleteMapping("/remove/{userId}")
	public ResponseEntity<ResponseDTO> deleteUserDetails(@PathVariable("userId") long userId) {
		userservice.deleteUserDetails(userId);
		ResponseDTO respDTO = new ResponseDTO("Delete user by id call successful", "Deleted id : " + userId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method to valid user
	 * 
	 * @param loginDTO : login credentials
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> userLogin(@RequestBody LoginDTO loginDTO) {
		String message = userservice.userLogin(loginDTO);
		ResponseDTO respDTO = new ResponseDTO("Login Status: ", message);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.ACCEPTED);
	}

	/**
	 * Get user by email
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("/find")
	public ResponseEntity<ResponseDTO> getUserByEmail(@RequestParam("email") String email) {
		User user1 = userservice.getUserEmailId(email);
		ResponseDTO respDTO = new ResponseDTO("Get user by email call successful", user1);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
