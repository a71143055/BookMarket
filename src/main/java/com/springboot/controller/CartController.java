package com.springboot.controller;

import com.springboot.domain.Cart;
import com.springboot.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping
    public String requestCartId(HttpServletRequest request) {
        System.out.println("aaaa");
        String sessionid = request.getSession(true).getId();
        return "redirect:/cart/" + sessionid;
    }
    @PostMapping
    public @ResponseBody Cart create(@RequestBody Cart cart) {
        System.out.println("bbb");
        return cartService.create(cart);
    }
    @GetMapping("{cartId}")
    public String requestCartList(@PathVariable(value = "cartId") String cardId, Model model) {
        System.out.println("ccc");
        Cart cart = cartService.read(cardId);
        model.addAttribute("cart", cart);
        return "cart";
    }
    @PutMapping("{cartId}")
    public @ResponseBody Cart read(@RequestBody Cart cart, @PathVariable(value = "cartId") String cartId) {
        System.out.println("dddd");
        return cartService.read(cartId);
    }
}
