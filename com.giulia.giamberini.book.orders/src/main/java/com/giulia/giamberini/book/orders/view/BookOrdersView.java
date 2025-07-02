package com.giulia.giamberini.book.orders.view;

import java.util.List;

import com.giulia.giamberini.book.orders.model.Book;
import com.giulia.giamberini.book.orders.model.Order;

public interface BookOrdersView {

	void showAllBooks(List<Book> books);
	
	void bookAdded(Book bookToAdd);

	void showErrorAlreadyExistingBook(String string, Book existingBook);

	void showAllOrders(List<Order> orders);

}
