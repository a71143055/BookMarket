package com.springboot.repository;

import com.springboot.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository {
    private Map<String, Cart> listOfCarts;
    public CartRepositoryImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }
    public Cart create(Cart cart) {
        if (listOfCarts.containsKey(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("장바구니를 생성할 수 없습니다. 장바구니 id(%)가 존재합니다.", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }
}
