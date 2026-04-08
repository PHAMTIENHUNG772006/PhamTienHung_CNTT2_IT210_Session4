package com.re.btth.service;

import com.re.btth.model.RestaurantTable; // Nhớ tạo class Model này
import com.re.btth.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("tableServicePractice")
public class TableService {

    @Autowired
    @Qualifier("tableRepoPractice")
    private TableRepository repo;

    public List<RestaurantTable> getAllTables() {
        return repo.getAll();
    }

    public List<RestaurantTable> getTablesByCapacity(int minCap) {
        if (minCap <= 0) {
            return repo.getAll();
        }
        return repo.getAll().stream()
                .filter(t -> t.getCapacity() >= minCap)
                .collect(Collectors.toList());
    }

    public RestaurantTable getTableById(int id) {
        return repo.getAll().stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public String deleteTable(int id) {
        repo.delete(id);
        return "Xóa thành công!";
    }
}