package com.example.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dateCreate;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private boolean status;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private Set<CartDetail> cartDetails;

}
