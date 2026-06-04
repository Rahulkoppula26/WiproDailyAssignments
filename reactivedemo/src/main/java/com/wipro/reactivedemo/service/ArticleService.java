package com.wipro.reactivedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.reactivedemo.model.Article;
import com.wipro.reactivedemo.repository.ArticleRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArticleService{

   @Autowired
   private ArticleRepository articleRepository;


   public Mono<Article> saveArticle(Article article) {

      return articleRepository.save(article);

      //for Mono<String> return type
      //return Mono.just("saved successfully");
   }


   public Flux<Article> findAllArticles() {

      return articleRepository.findAll().switchIfEmpty(Flux.empty());
   }

   public Mono<Article> findOneArticle(Integer id) {

      return articleRepository.findById(id).switchIfEmpty(Mono.empty());
   }


   public Flux<Article> findByAuthor(String author) {

      return articleRepository.findByAuthor(author);
   }


   public Mono<Void> deleteArticle(Integer id) {

      return articleRepository.deleteById(id);
   }
}