package com.example.book.controller;

import com.example.book.dTo.BookDto;
import com.example.book.entity.AppUser;
import com.example.book.entity.Book;
import com.example.book.entity.Category;
import com.example.book.entity.Customer;
import com.example.book.service.IBookService;
import com.example.book.service.ICustomerService;
import com.example.book.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/public/book")
public class BookRestController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public ResponseEntity<Page<Book>> getCategoryVn(@RequestParam(defaultValue = "",required = false) String name,
                                                    @RequestParam(defaultValue = "0",required = false) Integer idCategory,
                                                    @PageableDefault(value = 8) Pageable pageable){
        Page<Book> listVn = iBookService.FindAll(idCategory,name,pageable);
        if (listVn.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listVn,HttpStatus.OK);
    }
    @GetMapping("/list/show/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        Optional<Book> book = iBookService.findById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody BookDto bookDto, BindingResult bindingResult) {
            Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        iBookService.create(book);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody BookDto bookDto, BindingResult bindingResult) {
        Optional<Book> bookUpdate =iBookService.findById(id);
        if (bookUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Book books = new Book();
        BeanUtils.copyProperties(bookDto, books);

        books.setId(bookUpdate.get().getId());
         books.setCategory(bookUpdate.get().getCategory());

        iBookService.update(books);
                return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteExport(@PathVariable Integer id) {
        iBookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{username}")
    public ResponseEntity<Customer> findByUsername(@PathVariable String username) {
        Customer customer = iCustomerService.findByUsername(username);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = iCustomerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
