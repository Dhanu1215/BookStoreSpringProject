package com.example.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public @ToString class UserDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String address;
	public String password;

}
