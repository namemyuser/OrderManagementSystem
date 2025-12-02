package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Order;
import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order findById(String id);
    Order save(Order order);
    void update(Order order);
    void deleteById(String id);
}
