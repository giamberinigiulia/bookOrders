package com.giulia.giamberini.book.orders.model;

import java.util.List;
import java.util.Objects;

public class Order {

	private String ID;
	private List<Book> books;

	public Order(String iD, List<Book> books) {
		ID = iD;
		this.books = books;
	}

	public Order() {
	}

	public String getID() {
		return ID;
	}

	public List<Book> getBooks() {
		return books;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, books);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(books, other.books);
	}

	@Override
	public String toString() {
		return "Order [ID=" + ID + ", books=" + books + "]";
	}

}
