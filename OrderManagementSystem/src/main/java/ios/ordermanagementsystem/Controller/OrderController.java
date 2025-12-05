package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Model.Customer;
import ios.ordermanagementsystem.Service.OrderService;
import ios.ordermanagementsystem.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService,
                           CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    // ----- Thymeleaf Web page -----
    @GetMapping
    public String showOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "Orders/index";
    }

    // ----- REST: Get all orders as JSON -----
    @GetMapping("/api")
    @ResponseBody
    public List<Order> getAllOrdersApi() {
        return orderService.getAllOrders();
    }

    // ----- REST: Get single order by id -----
    @GetMapping("/api/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    // ----- REST: Create order -----
    @PostMapping("/api")
    @ResponseBody
    public Order addOrderApi(@RequestParam String product,
                             @RequestParam String unit,
                             @RequestParam int quantity,
                             @RequestParam Long customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            return null; // later: return 400/404 via @ResponseStatus
        }

        Order order = new Order();
        order.setProduct(product);
        order.setUnit(unit);
        order.setQuantity(quantity);
        order.setCustomer(customer);

        return orderService.addOrder(order);
    }

    // ----- REST: Modify (update) order -----
    @PutMapping("/api/{id}")
    @ResponseBody
    public Order updateOrder(@PathVariable Long id, @RequestBody Order newOrder) {
        Order existingOrder = orderService.getOrder(id);
        if (existingOrder == null) {
            return null;
        }
        existingOrder.setProduct(newOrder.getProduct());
        existingOrder.setUnit(newOrder.getUnit());
        existingOrder.setQuantity(newOrder.getQuantity());
        existingOrder.setCustomer(newOrder.getCustomer());
        return orderService.addOrder(existingOrder);
    }

    // ----- REST: Delete order -----
    @DeleteMapping("/api/{id}")
    @ResponseBody
    public void deleteOrder(@PathVariable Long id) {
        orderService.removeOrder(id);
    }
}
