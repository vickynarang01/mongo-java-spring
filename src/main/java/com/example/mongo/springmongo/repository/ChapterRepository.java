package com.example.mongo.springmongo.repository;

import com.example.mongo.springmongo.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter,Integer> {

}
