package com.api.book.bootrestbook.service;

import com.api.book.bootrestbook.entity.BookEntity;
import com.api.book.bootrestbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList;
    }

    public BookEntity getBookById(int id) {
        BookEntity bookEntity = null;

        try {
            bookEntity = bookRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookEntity;
    }

    public BookEntity saveBook(BookEntity bookEntity) {
        BookEntity book = bookRepository.save(bookEntity);
        return book;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(BookEntity bookEntity, int bookId) {
        bookEntity.setId(bookId);
        bookRepository.save(bookEntity);
    }
}
