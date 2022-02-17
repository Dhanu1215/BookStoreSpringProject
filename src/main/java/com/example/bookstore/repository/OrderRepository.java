package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.OrderData;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, Long> {


}
