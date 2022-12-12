package com.xie.service;


import com.xie.bean.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
