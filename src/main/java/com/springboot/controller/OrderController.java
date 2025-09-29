package com.springboot.controller;

import com.springboot.domain.*;
import com.springboot.service.CartService;
import com.springboot.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    Order order;
    List<Book> listofBooks;
    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
        Cart cart = cartService.validateCart(cartId);
        order = new Order();
        listofBooks = new ArrayList<>();
        for(CartItem item : cart.getCartItems().values()) {
            OrderItem orderItem = new OrderItem();
            Book book = item.getBook();
            listofBooks.add(book);
            orderItem.setBookId(book.getBookId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setTotalPrice(item.getTotalPrice());
            order.getOrderItems().put(book.getBookId(), orderItem);
        }
        order.setCustomer(new  Customer());
        order.setShipping(new  Shipping());
        order.setGrandTotal(cart.getGrandTotal());
        return "redirect:/order/orderCustomerInfo";
    }
    @GetMapping("/orderCustomerInfo")
    public String requestCustomerInfo(Model model) {
        model.addAttribute("customer", order.getCustomer());
        return "orderCustomerInfo";
    }
    @PostMapping("{/orderCustomerInfo")
    public String requestCustomerInfo(@ModelAttribute Customer customer, Model model) {
        order.setCustomer(customer);
        return"redirect:/order/orderShippingInfo";
    }
    @GetMapping("orderShippingInfo")
    public String requestShippingInfoForm(Model model) {
        model.addAttribute("shipping", order.getShipping());
        return "orderShippingInfo";
    }
    @PostMapping("orderShippingInfo")
    public String requestShippingInfo(@Valid @ModelAttribute Shipping shipping, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors())
            return "orderShippingInfo";
        order.setShipping(shipping);
        model.addAttribute("order", order);
        return "redirect/order/orderConfirmation";
    }
    @GetMapping("/orderConfirmation")
    public String requestConfirmation(Model model) {
        model.addAttribute("bookList", listofBooks);
        model.addAttribute("order", order);
        return "orderConfirmation";
    }
    @PostMapping("/orderConfirmation")
    public String requestConfirmationFinished(Model model) {
        model.addAttribute("order", order);
        orderService.saveOrder(order);
        return "redirect:/order/orderFinished";
    }
}
