package com.wipro.reactivedemo.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.wipro.reactivedemo.model.Article;

import reactor.core.publisher.Flux;

@Repository
public interface ArticleRepository extends ReactiveMongoRepository<Article, Integer> {

   @Query("{'author': ?0}")
   Flux<Article> findByAuthor(String author);

}