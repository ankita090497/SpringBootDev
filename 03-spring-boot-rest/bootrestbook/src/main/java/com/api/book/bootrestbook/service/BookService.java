package com.api.book.bootrestbook.service;

import com.api.book.bootrestbook.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static List<BookEntity> list = new ArrayList<>();

    static {
        list.add(new BookEntity(11, "SQL", "abc"));
        list.add(new BookEntity(12, "Oracle", "pqr"));
        list.add(new BookEntity(13, "Spring Boot", "mno"));
    }

    // Get All books
    public List<BookEntity> getAllBooks() {
        return list;
    }

    // get Single book by id
    public BookEntity getBookById(int id) {
        BookEntity book = null;
        book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
        return book;
    }
}
