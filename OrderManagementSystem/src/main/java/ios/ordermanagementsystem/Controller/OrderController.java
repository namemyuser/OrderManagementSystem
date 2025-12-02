package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.Customer;
import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // ----- Thymeleaf Web page -----
    @GetMapping("/orders-view")
    public String showOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "Orders/index";
    }

    // ----- REST: Get all orders as JSON -----
    @GetMapping("/api/orders")
    @ResponseBody
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // ----- REST: Get single order by id -----
    @GetMapping("/api/orders/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable String id) {
        Order order = orderRepository.findById(id);
        return order; // If not found, returns null
    }

    // ----- REST: Create order -----
    @PostMapping("/api/orders")
    public String addOrder(
            @RequestParam String id,
            @RequestParam String product,
            @RequestParam String unit,
            @RequestParam int quantity,
            @RequestParam String customerId,
            @RequestParam String customerName,
            @RequestParam String customerCurrency
    ) {
        Customer customer = new Customer(customerId, customerName, customerCurrency);
        Order order = new Order(id, product, unit, quantity, customer);
        orderRepository.save(order);
        return "redirect:/orders";
    }

    // ----- REST: Modify (update) order -----
    @PutMapping("/api/orders/{id}")
    @ResponseBody
    public Order updateOrder(@PathVariable String id, @RequestBody Order newOrder) {
        Order existingOrder = orderRepository.findById(id);
        if (existingOrder != null) {
            existingOrder.setProduct(newOrder.getProduct());
            existingOrder.setUnit(newOrder.getUnit());
            existingOrder.setQuantity(newOrder.getQuantity());
            existingOrder.setCustomer(newOrder.getCustomer());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    // ----- REST: Delete order -----
    @DeleteMapping("/api/orders/{id}")
    @ResponseBody
    public void deleteOrder(@PathVariable String id) {
        orderRepository.deleteById(id);
    }
}
