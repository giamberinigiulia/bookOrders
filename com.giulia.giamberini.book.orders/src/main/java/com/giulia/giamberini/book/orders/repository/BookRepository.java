package com.giulia.giamberini.book.orders.repository;

import java.util.List;

import com.giulia.giamberini.book.orders.model.Book;

public interface BookRepository {

	public List<Book> findAll();

	public Book findByISBN(String string);
	
	public void save(Book bookToAdd);

}
