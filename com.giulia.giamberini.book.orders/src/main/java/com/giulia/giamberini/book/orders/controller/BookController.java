package com.giulia.giamberini.book.orders.controller;

import com.giulia.giamberini.book.orders.repository.BookRepository;
import com.giulia.giamberini.book.orders.view.BookOrdersView;

public class BookController {

	private BookOrdersView bookOrdersView;
	private BookRepository bookRepository;

	public BookController(BookOrdersView bookOrdersView, BookRepository bookRepository) {
		this.bookOrdersView = bookOrdersView;
		this.bookRepository = bookRepository;
	}

	public void allBooks() {
		bookOrdersView.showAllBooks(bookRepository.findAll());
	}

}
