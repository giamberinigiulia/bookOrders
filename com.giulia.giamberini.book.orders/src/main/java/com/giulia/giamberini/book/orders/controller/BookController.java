package com.giulia.giamberini.book.orders.controller;

import com.giulia.giamberini.book.orders.model.Book;
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
	
	public void newBook(Book bookToAdd) {
		Book bookAlreadyExisting = bookRepository.findByISBN(bookToAdd.getISBN());
		if (bookAlreadyExisting != null) {
			bookOrdersView.showErrorAlreadyExistingBook("The ISBN " + bookToAdd.getISBN()+ " is already associated with the book", bookAlreadyExisting);
			return;
		}
		bookRepository.save(bookToAdd);
		bookOrdersView.bookAdded(bookToAdd);
	}

}
