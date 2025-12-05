package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Model.Customer;
import ios.ordermanagementsystem.Service.OrderService;
import ios.ordermanagementsystem.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderWebController {

    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderWebController(OrderService orderService,
                              CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    // List page: /orders
    @GetMapping
    public String showOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "Orders/index";
    }

    // Form page: /orders/new
    @GetMapping("/new")
    public String newOrderForm(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "Orders/form";
    }

    // Handle form submit: POST /orders
    @PostMapping
    public String addOrder(@RequestParam String product,
                           @RequestParam String unit,
                           @RequestParam int quantity,
                           @RequestParam Long customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            return "redirect:/orders/new";
        }

        Order order = new Order();
        order.setName("Order for " + product);   // ensure NOT NULL
        order.setProduct(product);
        order.setUnit(unit);
        order.setQuantity(quantity);
        order.setCustomer(customer);

        orderService.addOrder(order);
        return "redirect:/orders";
    }

    // Delete order: POST /orders/delete
    @PostMapping("/delete")
    public String deleteOrder(@RequestParam Long id) {
        orderService.removeOrder(id);
        return "redirect:/orders";
    }
}
