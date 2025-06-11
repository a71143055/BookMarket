package com.springboot.service;

import com.springboot.domain.Cart;
import com.springboot.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl {
    @Autowired
    private CartRepository cartRepository;
    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }
    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }
}
