package com.re.bai2.controller;


import com.re.bai2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("legacyControllerBai2")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/bai2/menu", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getMenu(@RequestParam( value = "category", required = false,  defaultValue = "chay") String category){

        return "Bạn đang xem thực đơn loại: " + category;
    }
}