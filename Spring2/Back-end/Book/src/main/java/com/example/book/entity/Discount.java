package com.example.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String percent;

    @OneToMany(mappedBy = "discount")
    @JsonIgnore
    private Set<Book> books;
}
