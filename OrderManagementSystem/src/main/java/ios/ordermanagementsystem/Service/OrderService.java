package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /** Standard CRUD methods **/
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(String id) {
        return orderRepository.findById(id);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void update(Order order) {
        orderRepository.update(order);
    }

    public void deleteById(String id) {
        orderRepository.deleteById(id);
    }

    /** Aliases for legacy code & WebControllers **/

    // For listing
    public List<Order> getAllOrders() { return findAll(); }

    // For fetching one order
    public Order getOrder(String id) { return findById(id); }

    // For creating
    public void addOrder(Order order) { save(order); }

    // For removing
    public void removeOrder(String id) { deleteById(id); }
}
