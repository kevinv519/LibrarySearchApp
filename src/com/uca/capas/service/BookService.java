package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Book;

public interface BookService {
	List<Book> getAllBooks() throws DataAccessException;
	
	List<Book> getFilteredBooks(String filter, String value) throws DataAccessException;
}
