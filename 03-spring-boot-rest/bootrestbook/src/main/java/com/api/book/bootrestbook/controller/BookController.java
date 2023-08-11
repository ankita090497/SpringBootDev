package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.entity.BookEntity;
import com.api.book.bootrestbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<BookEntity> getBooks() {
        List<BookEntity> bookEntityList = new ArrayList<>();
        bookEntityList = bookService.getAllBooks();
        return bookEntityList;
    }

    @GetMapping("/book/{id}")
    public BookEntity getBooks(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public BookEntity addBook(@RequestBody BookEntity bookEntity){

        BookEntity book = bookService.addBook(bookEntity);
        return book;
    }

}
