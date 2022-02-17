package com.example.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.bookstore.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Entity : Specifies that the class is an entity
 * @author praja
 *
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user_details")
public @Data class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column
	private String password;

	public User(UserDTO userDTO) {
		this.updateUserDetails(userDTO);
	}

	public void updateUserDetails(UserDTO userDTO) {
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.email = userDTO.getEmail();
		this.address = userDTO.getAddress();
		this.password = userDTO.getPassword();
	}
}
