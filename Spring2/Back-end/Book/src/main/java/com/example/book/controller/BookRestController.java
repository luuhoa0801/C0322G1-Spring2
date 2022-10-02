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
@RequestMapping("/api/book")
public class BookRestController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/list")
    public ResponseEntity<Page<Book>> getCategoryVn(@RequestParam(name = "page", defaultValue = "3") Integer page,
                                                    @RequestParam(defaultValue = "",required = false) String name,
                                                    @RequestParam(defaultValue = "0",required = false) Integer idCategory,
                                                    @PageableDefault(value = 10) Pageable pageable){
//        Sort sort = Sort.by("view").descending();
        Page<Book> listVn = iBookService.FindAll(idCategory,name,pageable);
        if (listVn.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listVn,HttpStatus.OK);
    }

}
