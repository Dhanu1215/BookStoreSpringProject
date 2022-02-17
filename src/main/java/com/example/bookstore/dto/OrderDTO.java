package com.example.bookstore.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderDTO {

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderDate;

	private long orderId;
	private long bookId;
	private long userId;
	private long cartId;
	private int price;
	private long quantity;
	private String address;

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
