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
		Order existingOrder = orderRepository.findByID(orderToAdd.getID());
		if (existingOrder != null) {
			bookOrdersView.showErrorAlreadyExistingOrder("The order with id " + orderToAdd.getID() + " already exists",
					existingOrder);
			return;
		}
		orderRepository.save(orderToAdd);
		bookOrdersView.orderAdded(orderToAdd);
	}

	public void deleteOrder(Order orderToRemove) {
		
	}
}
