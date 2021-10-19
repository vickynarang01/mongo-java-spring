package com.example.mongo.springmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//You don't need to add Chapter as a document if you do not want to build a relation between Booka dn Chapter

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Chapter")
public class Chapter {
    @Id
    private Integer number;
    private String name;
}
