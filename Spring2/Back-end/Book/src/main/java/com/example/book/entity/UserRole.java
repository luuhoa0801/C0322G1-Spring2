package com.example.book.entity;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private AppRole appRole;
}
