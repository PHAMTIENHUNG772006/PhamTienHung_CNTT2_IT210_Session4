package com.re.btth.repository;


import com.re.btth.model.RestaurantTable;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository("tableRepoPractice")
public class TableRepository {
    private static List<RestaurantTable> tables = new ArrayList<>();

    static {
        tables.add(new RestaurantTable(1, "Bàn Cửa Sổ", 2, "Trống"));
        tables.add(new RestaurantTable(2, "Bàn vip tửu lầu", 4, "Trống"));
        tables.add(new RestaurantTable(3, "Bàn tròn quý sờ tộc", 10, "Trống"));
    }

    public List<RestaurantTable> getAll() { return tables; }
    public void delete(int id) { tables.removeIf(t -> t.getId() == id); }
}