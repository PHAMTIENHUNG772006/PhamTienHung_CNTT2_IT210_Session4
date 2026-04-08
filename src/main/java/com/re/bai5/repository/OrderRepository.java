package com.re.bai5.repository;

import org.springframework.stereotype.Repository;

@Repository("orderRepositoryBai5")
public class OrderRepository {
    public String findOrder(int id) {
        return "Thông tin chi tiết đơn hàng số: " + id;
    }

    public String saveOrder() {
        return "Tạo mới đơn hàng thành công!";
    }

    public String deleteOrder(int id) {
        return "Đã xóa đơn hàng số: " + id + " khỏi hệ thống.";
    }
}