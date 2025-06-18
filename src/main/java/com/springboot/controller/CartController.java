package com.springboot.controller;

import com.springboot.domain.Book;
import com.springboot.domain.Cart;
import com.springboot.domain.CartItem;
import com.springboot.exception.BookIdException;
import com.springboot.service.BookService;
import com.springboot.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;
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
    @PutMapping("book/{bookId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCartByNewItem(@PathVariable("bookId") String bookId, HttpServletRequest request) {
        String sessionid = request.getSession(true).getId();
        Cart cart = cartService.read(sessionid);
        if (cart == null) cart = cartService.create(new Cart(sessionid));
        Book book = bookService.getBookById(bookId);
        if  (book == null) throw new IllegalArgumentException(new BookIdException(bookId));
        cart.addCartItem(new CartItem(book));
        cartService.update(sessionid, cart);
    }
    @DeleteMapping("/book/{bookId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartByItem(@PathVariable("bookId") String bookId, HttpServletRequest request) {
        String sessionid = request.getSession(true).getId();
        Cart cart = cartService.read(sessionid);
        if (cart == null) cart = cartService.create(new Cart(sessionid));
        Book book = bookService.getBookById(bookId);
        if (book == null) throw new IllegalArgumentException(new BookIdException(bookId));
        cart.removeCartItem(new CartItem(book));
        cartService.update(sessionid, cart);
    }

}
