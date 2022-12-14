package com.example.book.service;

import com.example.book.dTo.CartDetailDto;
import com.example.book.entity.AppUser;
import com.example.book.entity.Cart;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    AppUser findByName(String name);

    String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String password, String name);

    List<AppUser> findAll();

    void save(AppUser appUser);

    void createRegister(AppUser appUser);

    Integer findMaxId();

    Optional<AppUser> findById(Integer id);

    void edit(AppUser appUser);

    void deleteUser(int id);

    Boolean existsUsername(String username);

    Boolean existsEmail(String email);

    void sendEmail(Cart cart, List<CartDetailDto> list) throws MessagingException, UnsupportedEncodingException;

}
