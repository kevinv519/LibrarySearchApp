package com.uca.capas.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		List<Book> books = bookDao.findByField(filter, "%".concat(value).concat("%"));
		if (books != null) {
			if (filter.equals("title_book")) {
				System.out.println("Entro");
				books.stream().forEach(o -> o.setTitle(getFilteredFormat(o.getTitle(), value)));
				books.stream().forEach(o -> o.setTitle(getFilteredFormat(o.getTitle(), StringUtils.capitalize(value))));
				books.stream().forEach(o -> o.setTitle(getFilteredFormat(o.getTitle(), value.toLowerCase())));
				books.stream().forEach(o -> o.setTitle(getFilteredFormat(o.getTitle(), value.toUpperCase())));
			} else if (filter.equals("author_book")) {
				books.stream().forEach(o -> o.setAuthor(getFilteredFormat(o.getAuthor(), value)));
				books.stream().forEach(o -> o.setAuthor(getFilteredFormat(o.getAuthor(), StringUtils.capitalize(value))));
				books.stream().forEach(o -> o.setAuthor(getFilteredFormat(o.getAuthor(), value.toLowerCase())));
				books.stream().forEach(o -> o.setAuthor(getFilteredFormat(o.getAuthor(), value.toUpperCase())));
			} else if (filter.equals("isbn_book")) {
				books.stream().forEach(o -> o.setIsbn(getFilteredFormat(o.getIsbn(), value)));
				books.stream().forEach(o -> o.setIsbn(getFilteredFormat(o.getIsbn(), StringUtils.capitalize(value))));
				books.stream().forEach(o -> o.setIsbn(getFilteredFormat(o.getIsbn(), value.toLowerCase())));
				books.stream().forEach(o -> o.setIsbn(getFilteredFormat(o.getIsbn(), value.toUpperCase())));
			} else  {
				books.stream().forEach(o -> o.setGenre(getFilteredFormat(o.getGenre(), value)));
				books.stream().forEach(o -> o.setGenre(getFilteredFormat(o.getGenre(), StringUtils.capitalize(value))));
				books.stream().forEach(o -> o.setGenre(getFilteredFormat(o.getGenre(), value.toLowerCase())));
				books.stream().forEach(o -> o.setGenre(getFilteredFormat(o.getGenre(), value.toUpperCase())));
			}
		}
		return books;
	}
	
	private String getFilteredFormat(String field, String value) {
		String result = "<strong class='text-danger'>%s</strong>";
		return field.replaceAll(value, String.format(result, value));
	}
}
