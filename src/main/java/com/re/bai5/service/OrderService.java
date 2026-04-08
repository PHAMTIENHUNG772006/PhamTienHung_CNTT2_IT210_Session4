package com.re.bai5.service;

import com.re.bai5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderServiceBai5")
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(@Qualifier("orderRepositoryBai5") OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrderDetail(int id) { return orderRepository.findOrder(id); }
    public String createNewOrder() { return orderRepository.saveOrder(); }
    public String cancelOrder(int id) { return orderRepository.deleteOrder(id); }
}