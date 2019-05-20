package com.uca.capas.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.BookDAO;
import com.uca.capas.domain.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDao;

	@Override
	public List<Book> getAllBooks() throws DataAccessException {
		return bookDao.getAll();
	}

	@Override
	public List<Book> getFilteredBooks(String filter, String value) throws DataAccessException, IllegalArgumentException {
		if (!Arrays.asList("title", "author", "isbn", "genre").contains(filter)) {
			throw new IllegalArgumentException("El filtro seleccionado no es válido o fue alterado.");
		}
		filter = filter.concat("_book");
		return bookDao.findByField(filter, value);
	}

	@Override
	public Integer getAuthorsAmount() throws DataAccessException {
		return bookDao.getTotalAuthors();
	}

}
