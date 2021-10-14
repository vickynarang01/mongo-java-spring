package com.example.mongo.springmongo.controller;

import com.example.mongo.springmongo.model.Book;
import com.example.mongo.springmongo.model.Chapter;
import com.example.mongo.springmongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    public BookRepository repository;

    @PostMapping("/books")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "Book" +book.getId() +" is now added";
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id){
         repository.deleteById(id);
        return "Book "+id +" is now deleted";
    }

    @GetMapping("/book/{authorName}")
    public List<Book> getBookByBookName(@PathVariable String authorName){
        return repository.findByBookName(authorName);
    }

    @GetMapping("/booksAuthor/{authorName}")
    public List<Book> getBookByAuthorName(@PathVariable String authorName){
        return repository.findByAuthorName(authorName);
    }

    @GetMapping("/booksByBookAuthor/{bookName}/{authorName}")
    public List<Book> getBookByAuthorName(@PathVariable String bookName, @PathVariable String authorName){
        return repository.findByBookNameAndAuthorName(bookName,authorName);
    }


    @GetMapping("/bookByName/{bookName}")
    public List<Book> getBookByName(@PathVariable String bookName){
        /*Query query = new Query();
        query.addCriteria(Criteria.where("bookName").is(bookName));
        return repository.findOne(query,Book.class);*/
        return repository.findBookByName(bookName);
    }

    @GetMapping("/booksByBookAndAuthor/{bookName}/{authorName}")
    public List<Book> getBookByAuthorAndBook(@PathVariable String bookName, @PathVariable String authorName){
        return repository.findByBookAndAuthor(bookName,authorName);
    }

    @GetMapping("/booksByBookOrAuthor/{bookName}/{authorName}")
    public List<Book> getBooksByBookOrAuthor(@PathVariable String bookName, @PathVariable String authorName){
        return repository.findByBookNameOrAuthorName(bookName, authorName);
    }

    @GetMapping("/allWithPagination")
    public List<Book> getPaginatedData(@RequestParam int pageNo, @RequestParam int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return repository.findAll(pageable).getContent();
        //return repository.findAll().stream().skip((pageNo -1)*pageSize).limit(pageSize).collect(Collectors.toList());
    }

    @GetMapping("/booksSorted")
    public List<Book> getSortedBooks()
    {
        Sort sort = Sort.by(Sort.Direction.ASC,"bookName");
        return repository.findAll(sort);
        //return repository.findAll().stream().sorted((i1,i2) -> (i2.getBookName().compareTo(i1.getBookName()))).collect(Collectors.toList());
    }


    @GetMapping("/book/chapter")
    public List<Book> getChapter(@RequestParam int number){
        return repository.findByChapter_Number(number);
    }

    @GetMapping("/bookLike")
    public List<Book> getBooksLike(@RequestParam String bookName){
        return repository.findByBookNameRegex(bookName);
    }

}
