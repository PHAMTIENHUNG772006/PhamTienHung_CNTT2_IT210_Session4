package com.re.bai1.service;


import com.re.bai1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderServiceBai1")
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }
}