package com.giulia.giamberini.book.orders.controller;

import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.giulia.giamberini.book.orders.model.Book;
import com.giulia.giamberini.book.orders.repository.BookRepository;
import com.giulia.giamberini.book.orders.view.BookOrdersView;

public class BookControllerTest {

	@Mock
	private BookRepository bookRepository;

	@Mock
	private BookOrdersView bookOrdersView;

	@InjectMocks
	private BookController bookController;

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
	public void testAllBooks() {
		List<Book> books = Arrays.asList(new Book());
		when(bookRepository.findAll()).thenReturn(books);
		bookController.allBooks();
		verify(bookOrdersView).showAllBooks(books);
	}

	@Test
	public void testNewBookAdeddWhenNotAlreadyPresent() {
		Book bookToAdd = new Book("ISBN1", "title", "author", "genre");
		when(bookRepository.findByISBN("ISBN1")).thenReturn(null);
		bookController.newBook(bookToAdd);
		InOrder inOrder = inOrder(bookRepository, bookOrdersView);
		inOrder.verify(bookRepository).save(bookToAdd);
		inOrder.verify(bookOrdersView).bookAdded(bookToAdd);
	}

	@Test
	public void testNewBookAdeddWhenIsAlreadyPresent() {
		Book existingBook = new Book("ISBN1","title","author","genre");
		Book bookToAdd = new Book("ISBN1","new title","new author", "new genre");
		when(bookRepository.findByISBN("ISBN1")).thenReturn(existingBook);
		bookController.newBook(bookToAdd);
		verify(bookOrdersView).showErrorAlreadyExistingBook("The ISBN ISBN1 is already associated with the book",existingBook);
		verifyNoMoreInteractions(ignoreStubs(bookRepository));
	}
}
