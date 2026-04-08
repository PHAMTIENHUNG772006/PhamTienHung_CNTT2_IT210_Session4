package com.re.bai4.controller;


import com.re.bai4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("orderControllerBai4")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(@Qualifier("orderServiceBai4") OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/bai4/products")
    public String getProducts(@RequestParam("category") String category,
                              @RequestParam("limit") int limit,
                              ModelMap model) {
        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tìm kiếm thành công");
        return "productList";
    }

}