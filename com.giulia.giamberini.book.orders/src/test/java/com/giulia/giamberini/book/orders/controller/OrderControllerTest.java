package com.giulia.giamberini.book.orders.controller;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.giulia.giamberini.book.orders.model.Book;
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
		List<Order> orders = asList(new Order());
		when(orderRepository.findAll()).thenReturn(orders);
		orderController.allOrders();
		verify(bookOrdersView).showAllOrders(orders);
	}

	@Test
	public void testNewOrderIsCreatedWhenItDoesntAlreadyExist() {
		Order orderToAdd = new Order("1", asList(new Book()));
		when(orderRepository.findByID("1")).thenReturn(null);
		orderController.newOrder(orderToAdd);
		InOrder inOrder = inOrder(orderRepository, bookOrdersView);
		inOrder.verify(orderRepository).save(orderToAdd);
		inOrder.verify(bookOrdersView).orderAdded(orderToAdd);
	}
	
	@Test
	public void testNewOrderIsNotAddedWhenItAlreadyExists() {
		Order orderToAdd = new Order("1",asList(new Book()));
		Order existingOrder = new Order("1",asList(new Book()));
		when(orderRepository.findByID("1")).thenReturn(existingOrder);
		orderController.newOrder(orderToAdd);
		verify(bookOrdersView).showErrorAlreadyExistingOrder("The order with id 1 already exists", existingOrder);
		verifyNoMoreInteractions(ignoreStubs(orderRepository));
	}
}
