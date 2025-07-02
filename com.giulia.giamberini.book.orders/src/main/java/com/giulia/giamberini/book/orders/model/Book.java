package com.giulia.giamberini.book.orders.model;

import java.util.Objects;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private String genre;

	public Book(String iSBN, String title, String author, String genre) {
		this.ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public Book() {
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, author, genre, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author)
				&& Objects.equals(genre, other.genre) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", genre=" + genre + "]";
	}

}
