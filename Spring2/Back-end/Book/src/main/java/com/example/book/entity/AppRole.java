package com.example.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(45)", name = "role_name")
    private String roleName;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "appRole")
    @JsonIgnore
    private List<UserRole> userRoles;
}
