package com.example.mongo.springmongo.controller;

import com.example.mongo.springmongo.model.Book;
import com.example.mongo.springmongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

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

}
