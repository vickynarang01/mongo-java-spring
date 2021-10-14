package com.example.mongo.springmongo.repository;

import com.example.mongo.springmongo.model.Book;
import com.example.mongo.springmongo.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {
//for below 3 methods we need to pass exactly same field names as in the Book model
List<Book> findByBookName(String name);
List<Book> findByAuthorName(String name);
List<Book> findByBookNameAndAuthorName(String book, String author);
List<Book> findByBookNameOrAuthorName(String book, String author);

//custom query on book collection
@Query("{bookName:?0}")
List<Book> findBookByName(String name);

@Query("{ $and : [ {bookName:?0}, {authorName:?1}]}")
List<Book> findByBookAndAuthor(String bookName, String authorName);

List<Book> findByChapter_Number(int number);


@Query("{'bookName': {$regex : ?0}}")
List<Book> findByBookNameRegex(String bookName);
}

