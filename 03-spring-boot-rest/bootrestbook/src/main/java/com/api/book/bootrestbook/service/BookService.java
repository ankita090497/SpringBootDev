package com.api.book.bootrestbook.service;

import com.api.book.bootrestbook.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static List<BookEntity> list = new ArrayList<>();

    static {
        list.add(new BookEntity(11, "SQL", "abc"));
        list.add(new BookEntity(12, "Oracle", "pqr"));
        list.add(new BookEntity(13, "Spring Boot", "mno"));
        list.add(new BookEntity(14, "Spring", "xyz"));
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

    //Adding the book
    public BookEntity addBook(BookEntity bookEntity) {
        list.add(bookEntity);
        return bookEntity;
    }

    //delete book by Id
    public void deleteBook(int bookId) {
        list = list.stream().filter(book -> book.getBookId() != bookId).collect(Collectors.toList());
    }

    // update the book
    public void updateBook(BookEntity bookEntity, int bookId) {
        list = list.stream().map(b -> {
            if (b.getBookId() == bookId) {
                b.setBookTitle(bookEntity.getBookTitle());
                b.setBookAuthor(bookEntity.getBookAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
