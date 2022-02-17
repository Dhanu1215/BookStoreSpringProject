package com.example.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.bookstore.dto.BookDTO;

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
@Table(name = "book_details")
public @Data class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;

	@Column(name = "bookName")
	private String bookName;

	@Column(name = "bookDesc")
	private String bookDescription;

	@Column(name = "authorName")
	private String authorName;

	@Column(name = "bookImg")
	private String bookImg;

	@Column(name = "bookPrice")
	private long price;

	@Column(name = "bookQty")
	private long quantity;

	public Book(BookDTO bookDTO) {
		this.updateBookData(bookDTO);
	}

	public void updateBookData(BookDTO bookDTO) {
		this.bookName = bookDTO.getBookName();
		this.bookDescription = bookDTO.getBookDescription();
		this.authorName = bookDTO.getAuthorName();
		this.bookImg = bookDTO.getBookImg();
		this.price = bookDTO.getPrice();
		this.quantity = bookDTO.getQuantity();
	}

}
