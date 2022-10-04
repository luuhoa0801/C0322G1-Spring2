package com.example.book.service;

import com.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> FindAll(Integer idCategory,String name, Pageable pageable);

    Book findById(int id);
}
