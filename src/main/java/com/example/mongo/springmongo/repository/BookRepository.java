package com.example.mongo.springmongo.repository;

import com.example.mongo.springmongo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
