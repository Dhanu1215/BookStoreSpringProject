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
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.dto.CartDTO;
import com.example.bookstore.dto.ResponseDTO;
import com.example.bookstore.model.Cart;
import com.example.bookstore.service.ICartService;

/**
 * Rest Controller to handle the all rest calls
 * 
 * @RestController : CartController
 * @author praja
 */
@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

	/**
	 * @Autowired : Marks a constructor, field, setter method, or configure method
	 *            as to be autowired by Spring's dependency injection facilities.
	 */
	@Autowired
	private ICartService cartservice;

	/**
	 * Call Get method to handle get call It returns cart details
	 * 
	 * @return : Http Status & cart details
	 */
	@RequestMapping("/getcart")
	public ResponseEntity<ResponseDTO> getCartDetails() {
		List<Cart> cartList = null;
		cartList = cartservice.getCartDetails();
		ResponseDTO respDTO = new ResponseDTO("Get call successful", cartList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call Get method It returns cart details by cart Id
	 * 
	 * @param id : cart Id
	 * @return : cart details
	 */
	@GetMapping("/get/{cartId}")
	public ResponseEntity<ResponseDTO> getCartById(@PathVariable("cartId") long cartId) {
		Cart cart = null;
		cart = cartservice.getCartById(cartId);
		ResponseDTO respDTO = new ResponseDTO("Get cart by id call successful", cart);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method to add details It creates the cart details
	 * 
	 * @param cartDTO : cart details
	 * @return : details
	 */
	@PostMapping("/addcart")
	public ResponseEntity<ResponseDTO> addCart(@RequestBody CartDTO cartDTO) {
		Cart cart = null;
		cart = cartservice.addCart(cartDTO);
		ResponseDTO respDTO = new ResponseDTO("Created cart details successful", cart);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call put method to update details It update the cart by id.
	 * 
	 * @param cartDTO : cart details.
	 * @return : details
	 */

	@PutMapping("/update/{cartId}")
	public ResponseEntity<ResponseDTO> updateCartDetails(@PathVariable("cartId") long cartId,
			@RequestBody CartDTO cartDTO) {
		Cart cart = null;
		cart = cartservice.updateCartDetails(cartDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated cart details successful", cart);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call delete method to remove cart details It delete the cart details by cart
	 * id
	 * 
	 * @param id : cart id
	 * @return : cart id which is deleted
	 */
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<ResponseDTO> deleteCartDetails(@PathVariable("cartId") long cartId) {
		cartservice.deleteCartDetails(cartId);
		ResponseDTO respDTO = new ResponseDTO("Deleted cart details successfully", "Deleted id:" + cartId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
