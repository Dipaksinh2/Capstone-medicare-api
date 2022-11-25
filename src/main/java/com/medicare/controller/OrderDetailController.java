package com.medicare.controller;

import com.medicare.entity.OrderDetail;
import com.medicare.entity.OrderInput;
import com.medicare.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;


    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder"})
    public void placeOrder(@RequestBody OrderInput orderInput) {
        orderDetailService.placeOrder(orderInput);
    }

}
