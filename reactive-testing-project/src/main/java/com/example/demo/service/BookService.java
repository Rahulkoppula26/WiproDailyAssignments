package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

	private List<Book> books = new ArrayList<>();
	
    public Flux<Book> getAllBooks() {

                 books = List.of(
                new Book(1L, "Java", 500),
                new Book(2L, "Spring", 700),
                new Book(3L, "WebFlux", 900)
        );

        return Flux.fromIterable(books);
    }

    public Mono<Book> getBookById(Long id) {

        Book book = new Book(id, "Reactive Programming", 1000);

        return Mono.just(book);
    }
    
  
    	 public Mono<Book> saveBook() {
    		 
    		 Book book = new Book(4L, "Microservices", 1200);
    		 
    	        books.add(book);

    	        return Mono.just(book);
    	    }
    	 
    	 public Mono<Void> deleteBook(Long id){
    		  return Mono.empty();
    	 }
}
