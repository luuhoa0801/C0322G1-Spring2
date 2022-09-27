package com.example.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String name;
    private double price;
    private String description;
    private String dimension;
    private String translator;
    private String publishingHome;
    private String img;
    private int quantity;
    private int totalPage;
    private LocalDate releaseDate;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "discount_id",referencedColumnName = "id")
    private Discount discount;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private Set<CartDetail> cartDetails;


    public Book() {
    }


}
