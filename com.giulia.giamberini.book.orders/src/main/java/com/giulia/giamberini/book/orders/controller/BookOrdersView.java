package com.giulia.giamberini.book.orders.controller;

import java.util.List;

import com.giulia.giamberini.book.orders.model.Book;

public interface BookOrdersView {

	void showAllBooks(List<Book> books);

}
