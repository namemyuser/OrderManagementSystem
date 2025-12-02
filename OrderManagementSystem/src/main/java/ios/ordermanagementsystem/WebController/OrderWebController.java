package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Model.Customer;
import ios.ordermanagementsystem.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderWebController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "Orders/index";
    }

    @PostMapping("/orders")
    public String addOrder(
            @RequestParam String id,
            @RequestParam String product,
            @RequestParam String unit,
            @RequestParam int quantity,
            @RequestParam String customerId,
            @RequestParam String customerName,
            @RequestParam String customerCurrency
    ) {
        if (id == null || id.trim().isEmpty()) {
            // You may handle error here (show an error message in view)
            return "redirect:/orders";
        }
        Customer customer = new Customer(customerId, customerName, customerCurrency);
        Order order = new Order(id, product, unit, quantity, customer);
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @PostMapping("/orders/delete")
    public String deleteOrder(@RequestParam String id) {
        orderRepository.deleteById(id);
        return "redirect:/orders";
    }
}
