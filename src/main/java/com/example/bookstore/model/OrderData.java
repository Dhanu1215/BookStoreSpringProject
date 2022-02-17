package com.example.bookstore.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.bookstore.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Entity : Specifies that the class is an entity
 * @author praja
 *
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
@Data
public class OrderData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderDate;

	private int price;
	private long quantity;
	private String address;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_fk_id", referencedColumnName = "userId")
	private User userData;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_fk_id", referencedColumnName = "bookId")
	private Book bookDetails;

	private boolean cancel = false;

	public OrderData(OrderDTO orderDTO) {
		this.updateOrderDetails(orderDTO);
	}

	public void updateOrderDetails(OrderDTO orderDTO) {
		this.orderDate = LocalDate.now();
		this.price = orderDTO.getPrice();
		this.quantity = orderDTO.getQuantity();
		this.address = orderDTO.getAddress();
		this.cancel = false;
	}

	public void createOrder(OrderDTO orderDTO) {
		this.orderDate = LocalDate.now();
		this.price = orderDTO.getPrice();
		this.quantity = orderDTO.getQuantity();
		this.address = orderDTO.getAddress();
		this.cancel = false;
	}

}
