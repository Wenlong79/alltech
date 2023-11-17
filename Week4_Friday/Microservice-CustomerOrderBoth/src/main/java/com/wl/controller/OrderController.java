package com.wl.controller;

import com.wl.request.CreateOrderRequest;
import com.wl.response.OrderResponse;
import com.wl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public OrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }

    @GetMapping("getById/{id}")
    public OrderResponse getById(@PathVariable long id) {
        return orderService.getById(id);
    }

}
