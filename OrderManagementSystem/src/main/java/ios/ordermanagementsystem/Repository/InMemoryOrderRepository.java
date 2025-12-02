package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Model.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;


public class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public InMemoryOrderRepository() {
        // Demo data:
        orders.add(new Order("1", "Apple", "kg", 10, new Customer("101", "John Doe", "USD")));
        orders.add(new Order("2", "Banana", "kg", 5, new Customer("102", "Jane Smith", "EUR")));
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order findById(String id) {
        if (id == null) return null;
        for (Order order : orders) {
            if (order.getId() != null && order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order save(Order order) {
        if (order == null || order.getId() == null) {
            throw new IllegalArgumentException("Order or order ID must not be null");
        }
        if (findById(order.getId()) == null) {
            orders.add(order);
            return order;
        }
        return null;
    }

    @Override
    public void update(Order order) {
        if (order == null || order.getId() == null) {
            throw new IllegalArgumentException("Order or order ID must not be null");
        }
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId().equals(order.getId())) {
                orders.set(i, order);
                return;
            }
        }
        orders.add(order);
    }

    @Override
    public void deleteById(String id) {
        if (id == null) return;
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getId() != null && order.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
    }
}
