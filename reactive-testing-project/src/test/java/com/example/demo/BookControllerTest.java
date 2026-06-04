package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.controller.BookController;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private BookService service;

    @Test
    void testGetBooks() {

        when(service.getAllBooks()).thenReturn(
                Flux.just(
                        new Book(1L, "Java", 500),
                        new Book(2L, "Spring", 700),
                        new Book(3L, "WebFlux", 900)
                )
        );

        webTestClient.get()
                .uri("/books")
                .exchange()    // when the api executes it gives response
                .expectStatus().isOk()
                .expectBodyList(Book.class)
                .hasSize(3);
    }

    @Test
    void testGetBookById() {

        when(service.getBookById(1L))
                .thenReturn(Mono.just(
                        new Book(1L, "Reactive Programming", 1000)
                ));

        webTestClient.get()
                .uri("/books/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Reactive Programming");
    }
    @Test
    void testAddNewBook() {
    	
    	when(service.saveBook()).thenReturn(
                Mono.just(new Book(4L, "Microservices", 1200))
        );
    	
    	webTestClient.post()
        .uri("/books")
        .exchange()    // when the api executes it gives response
        .expectStatus().isOk()
        .expectBodyList(Book.class)
        .hasSize(1);
    	
      }
    
    @Test
    void testDeleteBookById() {

        when(service.deleteBook(1L))
                .thenReturn(Mono.empty());

        webTestClient.delete()
                .uri("/books/1")
                .exchange()
                .expectStatus().isOk();
    }
}




