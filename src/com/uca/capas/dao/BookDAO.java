package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Book;

public interface BookDAO {
	public List<Book> getAll() throws DataAccessException;
	
	public List<Book> findByField(String field, String value) throws DataAccessException;
	
	public Integer getTotalAuthors() throws DataAccessException;
}
