package com.springboot.service;

import com.springboot.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
}
