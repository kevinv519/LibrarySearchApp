package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Book;

public interface BookDAO {
	public List<Book> getAll() throws DataAccessException;
	
	public List<Book> findByTitle(String title) throws DataAccessException;
	
	public List<Book> findByIsbn(String isbn) throws DataAccessException;
	
	public List<Book> findByAuthor(String author) throws DataAccessException;
	
	public List<Book> findByGenre(String genre) throws DataAccessException;
	
	public Integer getTotalAuthors() throws DataAccessException;
}
