package com.example.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

    @JsonIgnore
    @OneToOne(mappedBy = "customer")
    private Cart cart;

    public Customer() {
    }

    public Customer(Integer id, String name, String address, LocalDate birthDay, String email, int phone, int gender,
                    boolean status, AppUser appUser, Cart cart) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.appUser = appUser;
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
