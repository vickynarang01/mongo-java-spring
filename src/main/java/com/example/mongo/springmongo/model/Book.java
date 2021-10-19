package com.example.mongo.springmongo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Book")
public class Book {

    @Id
    private int id;
    private String bookName;
    private String authorName;
    //For normal nested documents don't use DBRef i.e the standard way of NoSQL Dbs
    //DBRef will only be used when you want Chapter as a separate Collection and keep lazy as false by default to return both the Objects from the database
    @DBRef
    private Chapter chapter;
}
