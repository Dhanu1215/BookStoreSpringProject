package com.example.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CartDTO {

	private long cartId;
	private long quantity;
	private long userId;
	private long bookId;

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
