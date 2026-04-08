package com.re.bai5.controller;

import com.re.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Controller("orderControllerBai5")
@RequestMapping("/bai5")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(@Qualifier("orderServiceBai5") OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping(value = "/orders/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String viewOrder(@PathVariable("id") int id) {
        return orderService.getOrderDetail(id);
    }


    @PostMapping(value = "/orders", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String createOrder() {
        return orderService.createNewOrder();
    }


    @DeleteMapping(value = "/orders/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteOrder(@PathVariable("id") int id) {
        return orderService.cancelOrder(id);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public String handleTypeMismatch() {
        return "Lỗi: ID đơn hàng phải là một số nguyên. Vui lòng kiểm tra lại!";
    }
}