package com.example.book.service;

import com.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Book> FindAll(Integer idCategory,String name, Pageable pageable);

    Optional<Book> findById(int id);

    void create(Book book);

    void update(Book book);
}
