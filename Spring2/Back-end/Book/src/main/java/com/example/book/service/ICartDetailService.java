package com.example.book.service;

import com.example.book.entity.CartDetail;

import java.util.List;

public interface ICartDetailService {
    CartDetail save(CartDetail cartDetail);

    List<CartDetail> findCartDetail(Integer id);
}
