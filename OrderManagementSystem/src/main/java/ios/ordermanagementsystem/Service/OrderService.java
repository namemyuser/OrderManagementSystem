package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /** Standard CRUD methods **/

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    /** Aliases for WebControllers **/

    public List<Order> getAllOrders() {
        return findAll();
    }

    public Order getOrder(Long id) {
        return findById(id);
    }

    public Order addOrder(Order order) {
        return save(order);
    }

    public void removeOrder(Long id) {
        deleteById(id);
    }
}
