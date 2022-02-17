package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.model.OrderData;

public interface IOrderService {

	List<OrderData> getOrderDetails();

	OrderData getOrderById(long orderId);

	OrderData addOrderDetails(OrderDTO orderDTO);

	OrderData updateOrderDetails(long orderId, OrderDTO orderDTO);

	String deleteOrderDetails(long orderId, long userId, long bookId);

}
