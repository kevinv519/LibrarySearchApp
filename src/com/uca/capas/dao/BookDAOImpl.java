package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Book> getAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM book");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public List<Book> findByTitle(String title) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM book WHERE title_book LIKE '%?1%'");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		query.setParameter(1, title);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public List<Book> findByIsbn(String isbn) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM book WHERE isbn_book LIKE '%?1%'");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		query.setParameter(1, isbn);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public List<Book> findByAuthor(String author) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM book WHERE author_book LIKE '%?1%'");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		query.setParameter(1, author);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public List<Book> findByGenre(String genre) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM book WHERE genre_book LIKE '%?1%'");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		query.setParameter(1, genre);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public Integer getTotalAuthors() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT COUNT(DISTINCT author_book) FROM book");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		Integer total = Integer.valueOf(query.getSingleResult().toString());
		return total;
	}

}
