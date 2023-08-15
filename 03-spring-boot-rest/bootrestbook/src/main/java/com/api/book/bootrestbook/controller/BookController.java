package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.entity.BookEntity;
import com.api.book.bootrestbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookEntity>> getBooks() {
        List<BookEntity> bookEntityList = new ArrayList<>();
        bookEntityList = bookService.getAllBooks();
        if (bookEntityList.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bookEntityList));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookEntity> getBooks(@PathVariable("id") int id) {
        BookEntity bookEntity = bookService.getBookById(id);
        if (bookEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bookEntity));
    }

    @PostMapping("/books")
    public BookEntity addBook(@RequestBody BookEntity bookEntity) {
        BookEntity book = bookService.addBook(bookEntity);
        return book;
    }

    @DeleteMapping("/book/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("/book/{bookId}")
    public BookEntity updateBook(@RequestBody BookEntity bookEntity, @PathVariable("bookId") int bookId) {
        bookService.updateBook(bookEntity, bookId);
        return bookEntity;
    }
}
