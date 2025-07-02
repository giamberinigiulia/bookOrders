package com.giulia.giamberini.book.orders.controller;

import com.giulia.giamberini.book.orders.model.Order;
import com.giulia.giamberini.book.orders.repository.OrderRepository;
import com.giulia.giamberini.book.orders.view.BookOrdersView;

public class OrderController {

	private OrderRepository orderRepository;
	private BookOrdersView bookOrdersView;

	public OrderController(OrderRepository orderRepository, BookOrdersView bookOrdersView) {
		this.orderRepository = orderRepository;
		this.bookOrdersView = bookOrdersView;
	}

	public void allOrders() {
		bookOrdersView.showAllOrders(orderRepository.findAll());
	}

	public void newOrder(Order orderToAdd) {
		
	}
}
