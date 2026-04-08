package com.re.bai3.controller;


import com.re.bai3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("orderControllerBai3")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(@Qualifier("orderServiceBai3") OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/bai3/orders/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getOrder(@PathVariable("id") String id){

        return "Chi tiết đơn hàng số : " + id;
    }
}