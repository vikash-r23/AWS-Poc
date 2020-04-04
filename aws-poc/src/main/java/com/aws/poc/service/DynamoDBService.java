package com.aws.poc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.poc.entity.Book;
import com.aws.poc.repository.BookRepository;

@Service
public class DynamoDBService {

	@Autowired
	BookRepository repo;

	public Book getById(String id) {
		Optional<Book> book = repo.findById(id);
		if (!book.isPresent()) {
			throw new RuntimeException("Book not found");
		}
		return book.get();
	}
}
