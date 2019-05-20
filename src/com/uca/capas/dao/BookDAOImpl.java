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
	public List<Book> findByField(String field, String value) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM book WHERE LOWER(").append(field).append(") LIKE LOWER(?1)");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		query.setParameter(1, value);
		List<Book> books = query.getResultList();
		return books;
	}
}
