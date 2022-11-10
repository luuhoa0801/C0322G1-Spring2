package com.example.book.dTo;

import com.example.book.entity.AppUser;
import com.example.book.entity.Cart;

import java.time.LocalDate;

public class CustomerDto {
    private Integer id;
    private String name;
    private String address;
    private LocalDate birthDay;
    private String email;
    private int phone;
    private int gender;
    private boolean status;
    private AppUserDto appUser;
    private Cart cart;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String address, LocalDate birthDay, String email,
                       int phone, int gender, boolean status, AppUserDto appUser, Cart cart) {
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

    public AppUserDto getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUserDto appUser) {
        this.appUser = appUser;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
