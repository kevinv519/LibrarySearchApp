package com.uca.capas.service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.uca.capas.dao.BookDAO;
import com.uca.capas.domain.Book;

@Service
public class BookServiceImpl implements BookService {
	private static final Logger log = Logger.getLogger(BookServiceImpl.class.getSimpleName());
	
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
				books.stream().forEach(o -> o.setTitle(getFilteredFormat(o.getTitle(), value)));
			} else if (filter.equals("author_book")) {
				books.stream().forEach(o -> o.setAuthor(getFilteredFormat(o.getAuthor(), value)));
			} else if (filter.equals("isbn_book")) {
				books.stream().forEach(o -> o.setIsbn(getFilteredFormat(o.getIsbn(), value)));
			} else  {
				books.stream().forEach(o -> o.setGenre(getFilteredFormat(o.getGenre(), value)));
			}
		}
		return books;
	}
	
	private String getFilteredFormat(String field, String value) {
		String fieldLowerCase = field.toLowerCase();
		value = value.toLowerCase();
		int index = fieldLowerCase.indexOf(value);
		int delta = 0;
		String result = "<strong class='text-danger'>%s</strong>";
		while (index != -1) {
			delta = index + value.length();
			String match = String.format(result, field.substring(index, delta));
			field = field.substring(0, index) + match + field.substring(delta);
			fieldLowerCase = field.toLowerCase();
			index = fieldLowerCase.indexOf(value, index + match.length());
		}
		return field;
	}
}
