package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/public/book")
public class BookRestController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/list")
//    @RequestParam(name = "page", defaultValue = "3") Integer page,
    public ResponseEntity<Page<Book>> getCategoryVn(
                                                    @RequestParam(defaultValue = "",required = false) String name,
                                                    @RequestParam(defaultValue = "0",required = false) Integer idCategory,
                                                    @PageableDefault(value = 8) Pageable pageable){
//        Sort sort = Sort.by("view").descending();
        Page<Book> listVn = iBookService.FindAll(idCategory,name,pageable);
        if (listVn.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listVn,HttpStatus.OK);
    }
    @GetMapping("/list/show/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        Book book = iBookService.findById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

}
