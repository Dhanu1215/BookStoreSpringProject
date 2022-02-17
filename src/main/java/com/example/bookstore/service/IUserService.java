package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.dto.LoginDTO;
import com.example.bookstore.dto.UserDTO;
import com.example.bookstore.model.User;

public interface IUserService {

	List<User> getUserDetails();

	User getUserById(long userId);

	User createUserDetails(UserDTO userDTO);

	User updateUserDetailsById(long userId, UserDTO userDTO);

	void deleteUserDetails(long userId);

	User getUserEmailId(String email);

	String userLogin(LoginDTO loginDTO);

}
