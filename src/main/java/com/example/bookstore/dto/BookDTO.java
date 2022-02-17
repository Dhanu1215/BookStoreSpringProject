package com.example.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public @ToString class BookDTO {

	private String bookName;
	private String bookDescription;
	private String authorName;
	private String bookImg;
	private long price;
	private long quantity;

}
