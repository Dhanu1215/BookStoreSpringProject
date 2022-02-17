package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.exception.BookStoreException;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.OrderData;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CartRepository;
import com.example.bookstore.repository.OrderRepository;
import com.example.bookstore.repository.UserRepository;

/**
 * PersonService : Business logic
 * 
 * @author praja
 *
 */
@Service
public class OrderService implements IOrderService {

	/**
	 * Introducing Dao layer to store the data in database
	 */

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private BookRepository bookrepo;

	@Autowired
	private OrderRepository orderrepo;

	@Autowired
	private CartRepository cartrepo;

	/**
	 * Call Get method
	 * 
	 * @return : order details of the person
	 */
	@Override
	public List<OrderData> getOrderDetails() {
		return orderrepo.findAll();
	}

	/**
	 * Call Get method
	 * 
	 * @param id : order Id
	 * @return : order details
	 */
	@Override
	public OrderData getOrderById(long orderId) {
		return orderrepo.findById(orderId).get();
	}

	/**
	 * Call post method to add details
	 * 
	 * @param orderDTO : order details
	 * @return : details
	 */
	@Override
	public OrderData addOrderDetails(OrderDTO orderDTO) {
		OrderData order = new OrderData();
		Optional<Book> book = bookrepo.findById(orderDTO.getBookId());
		Optional<User> user = userrepo.findById(orderDTO.getUserId());

		if (book.isPresent() && user.isPresent() && (book.get().getQuantity()) >= (orderDTO.getQuantity())) {
			order.setUserData(user.get());
			book.get().setQuantity((book.get().getQuantity()) - (orderDTO.getQuantity()));
			cartrepo.deleteById(orderDTO.getCartId());
			order.setBookDetails(book.get());
			order.createOrder(orderDTO);
		} else {
			String mess = "Out of Stock..";
			throw new BookStoreException(mess);
		}
		return orderrepo.save(order);

	}

	/**
	 * Call put method to update details
	 * 
	 * @param orderDTO : order details
	 * @return : details
	 */
	@Override
	public OrderData updateOrderDetails(long orderId, OrderDTO orderDTO) {
		OrderData order = this.getOrderById(orderId);
		Optional<Book> book = bookrepo.findById(orderDTO.getBookId());
		Optional<User> user = userrepo.findById(orderDTO.getUserId());
		if (book.isPresent() && user.isPresent()) {
			order.setUserData(user.get());
			book.get().setQuantity((book.get().getQuantity()) - (orderDTO.getQuantity()));
			order.setBookDetails(book.get());
			order.createOrder(orderDTO);
		}
		return orderrepo.save(order);
	}

	/**
	 * Call delete method to remove order details
	 * 
	 * @param id : order id
	 * @return : order id which is deleted
	 */
	@Override
	public String deleteOrderDetails(long orderId, long userId, long bookId) {
		Optional<User> user = userrepo.findById(userId);
		if (user.isPresent()) {
			Optional<OrderData> order = Optional.ofNullable(this.getOrderById(orderId));
			if (order.isPresent()) {
				order.get().setCancel(true);
				Book book = bookrepo.getById(bookId);
				book.setQuantity((book.getQuantity()) + (order.get().getQuantity()));
				orderrepo.save(order.get());
			}
		}
		return "Cancel order Successfull";
	}

}
