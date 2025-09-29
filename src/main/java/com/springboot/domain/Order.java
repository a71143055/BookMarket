package com.springboot.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {
    @Id @GeneratedValue
    private Long orderId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shipping_id")
    private Shipping shipping;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_order_id")
    private Map<String,OrderItem> orderItems = new HashMap<>();
    private BigDecimal totalPrice;
}
