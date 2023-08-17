package com.api.book.bootrestbook.repository;

import com.api.book.bootrestbook.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    public BookEntity findById(int id);
}
