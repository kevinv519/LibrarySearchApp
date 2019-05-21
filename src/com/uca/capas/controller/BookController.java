package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Book;
import com.uca.capas.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	private static final Logger log = Logger.getLogger(BookController.class.getSimpleName());	
	
	@Autowired
	BookService bookService;
	
	@GetMapping()
	public ModelAndView allBooks() {
		ModelAndView mav = new ModelAndView("books-table");
		List<Book> books = null;
		Integer totalAuthors = null;
		int totalBooks = 0;
		try {
			books = bookService.getAllBooks();
			totalBooks = books.stream().mapToInt(Book::getQuantity).sum();
			log.info(totalBooks + "");
			totalAuthors = (int) books.stream().map(Book::getAuthor).distinct().count();
			log.info(totalAuthors.toString());
		} catch (DataAccessException e) {
			log.log(Level.WARNING, "Could not load books", e);
			mav.addObject("error", "Could not load books");
		}
		mav.addObject("isSearch", false);
		mav.addObject("books", books);
		mav.addObject("authors", totalAuthors);
		mav.addObject("totalBooks", totalBooks);
		return mav;
	}
	
	@GetMapping("/search")
	public ModelAndView filterBooks(@RequestParam String filter, @RequestParam String value) {
		ModelAndView mav = new ModelAndView("books-table");
		List<Book> books = null;
		value = value.trim();
		try {
			books = bookService.getFilteredBooks(filter, value);
		} catch(DataAccessException e) {
			log.log(Level.WARNING, "Could not load books", e);
			mav.addObject("error", "Could not load books");
		}
		mav.addObject("isSearch", true);
		mav.addObject("books", books);
		String filtro;
		if (filter.equals("title")) {
			filtro = "título";
		} else if (filter.equals("author")) {
			filtro = "autor";
		} else if (filter.equals("isbn")) {
			filtro = "ISBN";
		} else {
			filtro = "género";
		}
		mav.addObject("criteria", filtro);
		mav.addObject("value", value);
		return mav;
	}
}
