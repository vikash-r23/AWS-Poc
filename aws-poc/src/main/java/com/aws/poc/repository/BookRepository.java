package com.aws.poc.repository;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.aws.poc.entity.Book;

@EnableScan
public interface BookRepository extends CrudRepository<Book, String> {

	Optional<Book> findById(String id);
}