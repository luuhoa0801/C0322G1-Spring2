package com.example.book.service.impl;

import com.example.book.entity.Customer;
import com.example.book.repository.CustomerRepository;
import com.example.book.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findHistoryByUsername(String username) {
        return customerRepository.findHistoryByUser(username);
    }
}
