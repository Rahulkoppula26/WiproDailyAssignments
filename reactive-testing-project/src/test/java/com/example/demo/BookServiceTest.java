package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.service.BookService;

import reactor.test.StepVerifier;

public class BookServiceTest {

    BookService service = new BookService();

    @Test
    void testGetAllBooks() {

        StepVerifier.create(service.getAllBooks())
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void testGetBookById() {

        StepVerifier.create(service.getBookById(1L))
                .expectNextMatches(book ->
                        book.getName().equals("Reactive Programming"))
                .verifyComplete();
    }
}
