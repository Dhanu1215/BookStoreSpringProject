package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.dto.LoginDTO;
import com.example.bookstore.dto.UserDTO;
import com.example.bookstore.exception.BookStoreException;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.UserRepository;

/**
 * PersonService : Business logic
 * 
 * @author praja
 *
 */
@Service
public class UserService implements IUserService {

	/**
	 * Introducing Dao layer to store the data in database
	 */
	@Autowired
	private UserRepository userrepo;

	/**
	 * Call Get method
	 * 
	 * @return : user details
	 */
	@Override
	public List<User> getUserDetails() {
		return userrepo.findAll();
	}

	/**
	 * Call Get method
	 * 
	 * @param id : user Id
	 * @return : user details
	 */
	@Override
	public User getUserById(long userId) {
		return userrepo.findById(userId).get();
	}

	/**
	 * Call post method to add details
	 * 
	 * @param userDTO : user details
	 * @return : details
	 */
	@Override
	public User createUserDetails(UserDTO userDTO) {
		User user = null;
		user = new User(userDTO);
		return userrepo.save(user);
	}

	/**
	 * Call put method to update details
	 * 
	 * @param userDTO : user details
	 * @return : details
	 */
	@Override
	public User updateUserDetailsById(long userId, UserDTO userDTO) {
		User user = this.getUserById(userId);
		user.updateUserDetails(userDTO);
		return userrepo.save(user);
	}

	/**
	 * Call delete method to remove user details
	 * 
	 * @param id : user id
	 * @return : user id which is deleted
	 */
	@Override
	public void deleteUserDetails(long userId) {
		userrepo.deleteById(userId);
	}

	/**
	 * Get
	 */
	@Override
	public User getUserEmailId(String email) {
		List<User> data = this.getUserDetails();
		User option = data.stream().filter(n -> n.getEmail().equals(email)).findFirst().get();
		return option;
	}

	/**
	 * Validation of login credentials return: message LoginDTO: login credentials
	 */
	@Override
	public String userLogin(LoginDTO loginDTO) {
		String mess = null;
		User newUser = this.getUserEmailId(loginDTO.getEmail());
		Optional<User> user = Optional.of(this.getUserEmailId(loginDTO.getEmail()));
		if (user.isPresent()) {
			if (newUser.getPassword().equals(loginDTO.getPassword())) {
				mess = "Login Successfull...";
				return mess;
			} else {
				mess = "Login Failed.(Enter valid Credentials)";
				throw new BookStoreException(mess);

			}

		}
		return mess;

	}

}
