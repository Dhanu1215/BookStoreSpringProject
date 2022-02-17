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

import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.dto.ResponseDTO;
import com.example.bookstore.model.OrderData;
import com.example.bookstore.service.IOrderService;

/**
 * Rest Controller to handle the all rest calls
 * 
 * @RestController : OrderController
 * @author praja
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

	/**
	 * @Autowired : Marks a constructor, field, setter method, or configure method
	 *            as to be autowired by Spring's dependency injection facilities.
	 */
	@Autowired
	private IOrderService orderservice;

	/**
	 * Call Get method to handle get call It returns order details
	 * 
	 * @return : Http Status & order details
	 */
	@RequestMapping("/getorders")
	public ResponseEntity<ResponseDTO> getOrderDetails() {
		List<OrderData> orderList = null;
		orderList = orderservice.getOrderDetails();
		ResponseDTO respDTO = new ResponseDTO("Get call successful", orderList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call Get method It returns order details by order Id
	 * 
	 * @param id : order Id
	 * @return : order details
	 */
	@GetMapping("get/{orderId}")
	public ResponseEntity<ResponseDTO> getOrderById(@PathVariable("orderId") long orderId) {
		OrderData order = null;
		order = orderservice.getOrderById(orderId);
		ResponseDTO respDTO = new ResponseDTO("Get order by id call successful", order);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method to add details It creates the order details
	 * 
	 * @param orderDTO : order details
	 * @return : details
	 */
	@PostMapping("/addorder")
	public ResponseEntity<ResponseDTO> addOrderDetails(@RequestBody OrderDTO orderDTO) {
		OrderData order = null;
		order = orderservice.addOrderDetails(orderDTO);
		ResponseDTO respDTO = new ResponseDTO("Created order details successfully", order);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call put method to update details It update the order by id.
	 * 
	 * @param orderDTO : order details.
	 * @return : details
	 */
	@PutMapping("update/{orderId}")
	public ResponseEntity<ResponseDTO> updateOrderDetails(@PathVariable("orderId") long orderId,
			@RequestBody OrderDTO orderDTO) {
		OrderData order = null;
		order = orderservice.updateOrderDetails(orderId, orderDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated order details successfully", order);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call delete method to remove order details It delete the order details by
	 * order id
	 * 
	 * @param id : order id
	 * @return : order id which is deleted
	 */
	@DeleteMapping("/remove/{orderId}/{userId}/{bookId}")
	public ResponseEntity<ResponseDTO> deleteOrderDetails(@PathVariable("orderId") long orderId,
			@PathVariable("userId") long userId, @PathVariable("bookId") long bookId) {
		String order = orderservice.deleteOrderDetails(orderId, userId, bookId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Id: " + orderId, order);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.ACCEPTED);
	}
}
