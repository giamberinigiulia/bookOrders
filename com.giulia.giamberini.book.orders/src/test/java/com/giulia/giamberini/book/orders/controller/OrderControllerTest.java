package com.giulia.giamberini.book.orders.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.giulia.giamberini.book.orders.model.Order;
import com.giulia.giamberini.book.orders.repository.OrderRepository;
import com.giulia.giamberini.book.orders.view.BookOrdersView;

public class OrderControllerTest {

	@Mock
	private OrderRepository orderRepository;
	
	@Mock
	private BookOrdersView bookOrdersView;
	
	@InjectMocks
	private OrderController orderController;
	
	private AutoCloseable closeable;
	
	@Before
	public void setup() {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@After
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	@Test
	public void testAllOrders() {
		List<Order> orders = Arrays.asList(new Order());
		when(orderRepository.findAll()).thenReturn(orders);
		orderController.allOrders();
		verify(bookOrdersView).showAllOrders(orders);
	}

}
