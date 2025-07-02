package com.giulia.giamberini.book.orders.repository;

import java.util.List;

import com.giulia.giamberini.book.orders.model.Order;

public interface OrderRepository {

	public List<Order> findAll();

}
