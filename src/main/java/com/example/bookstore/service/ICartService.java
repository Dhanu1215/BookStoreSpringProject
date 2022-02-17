package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.dto.CartDTO;

import com.example.bookstore.model.Cart;

public interface ICartService {

	List<Cart> getCartDetails();

	Cart getCartById(long cartId);

	Cart updateCartDetails(CartDTO cartDTO);

	void deleteCartDetails(long cartId);

	Cart addCart(CartDTO cartDTO);

}
