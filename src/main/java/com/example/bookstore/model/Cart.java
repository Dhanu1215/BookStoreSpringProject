package com.example.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Entity : Specifies that the class is an entity
 * @author praja
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_details")
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;

	@OneToOne
	@JoinColumn(name = "user_fk_id", referencedColumnName = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "book_fk_id", referencedColumnName = "bookId")
	private Book book;

	private long quantity;

	public Cart(User user, Book book, long quantity) {
		this.user = user;
		this.book = book;
		this.quantity = quantity;
	}

	public Cart orElseThorw(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
