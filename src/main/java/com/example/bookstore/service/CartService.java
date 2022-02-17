package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.dto.CartDTO;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Cart;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.CartRepository;

/**
 * PersonService : Business logic
 * 
 * @author praja
 *
 */
@Service
public class CartService implements ICartService {

	/**
	 * Introducing Dao layer to store the data in database
	 */
	@Autowired
	private CartRepository cartrepo;

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookservice;

	/**
	 * Call Get method
	 * 
	 * @return : cart details
	 */
	@Override
	public List<Cart> getCartDetails() {
		return cartrepo.findAll();
	}

	/**
	 * Call Get method
	 * 
	 * @param id : cart Id
	 * @return : cart details
	 */
	@Override
	public Cart getCartById(long cartId) {
		return cartrepo.findById(cartId).get();
	}

	/**
	 * Call post method to add details
	 * 
	 * @param cartDTO : cart details
	 * @return : details
	 */
	@Override
	public Cart addCart(CartDTO cartDTO) {
		Optional<User> user = Optional.ofNullable(userService.getUserById(cartDTO.getUserId()));
		if (user.isPresent()) {
			Book book1 = bookservice.getBookById(cartDTO.getBookId());
			Cart cart = new Cart(user.get(), book1, cartDTO.getQuantity());
			return cartrepo.save(cart);
		}
		return null;
	}

	/**
	 * Call put method to update details
	 * 
	 * @param cartDTO : cart details
	 * @return : details
	 */
	@Override
	public Cart updateCartDetails(CartDTO cartDTO) {
		Optional<User> user = Optional.ofNullable(userService.getUserById(cartDTO.getUserId()));

		if (user.isPresent()) {
			Cart cart = this.getCartById(cartDTO.getCartId());
			cart.setQuantity(cartDTO.getQuantity());
			return cartrepo.save(cart);
		}
		return null;
	}

	/**
	 * Call delete method to remove cart details
	 * 
	 * @param id : cart id
	 * @return : cart id which is deleted
	 */
	@Override
	public void deleteCartDetails(long cartId) {
		cartrepo.deleteById(cartId);
	}

}
