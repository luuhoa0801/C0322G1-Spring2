package com.example.book.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private LocalDate birthDay;
    private String email;
    private int phone;
    private int gender;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private boolean status;



}
