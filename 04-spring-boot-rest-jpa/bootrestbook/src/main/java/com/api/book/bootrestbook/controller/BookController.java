package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.entity.BookEntity;
import com.api.book.bootrestbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(bookEntityList);
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
    public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity bookEntity) {
        BookEntity book = null;
        try {
            book = bookService.saveBook(bookEntity);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {

        try {
            bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity bookEntity, @PathVariable("bookId") int bookId) {
        try {
            bookService.updateBook(bookEntity, bookId);
            return ResponseEntity.ok().body(bookEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
