package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "book")
public class Book {
	@Id
	@GeneratedValue(generator = "book_id_generator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "book_id_generator", sequenceName = "public.book_id_book_seq", allocationSize = 1)
	@Column(name = "id_book")
	private Integer id;
	
	@Column(name = "title_book")
	private String title;
	
	@Column(name = "author_book")
	private String author;
	
	@Column(name = "isbn_book")
	private String isbn;
	
	@Column(name = "genre_book")
	private String genre;
	
	@Column(name = "stock_book")
	private Integer quantity;

	public Book(Integer id, String title, String author, String isbn, String genre, Integer quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.genre = genre;
		this.quantity = quantity;
	}
	
	public Book() {
		id = 0;
		title = "";
		author = "";
		isbn = "";
		genre = "";
		quantity = 0;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getGenre() {
		return genre;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
