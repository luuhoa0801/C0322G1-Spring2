package com.example.book.service.impl;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> FindAll(Integer idCategory, String name, Pageable pageable) {
        return bookRepository.findAll(idCategory,"%" +name+"%",pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }
}
