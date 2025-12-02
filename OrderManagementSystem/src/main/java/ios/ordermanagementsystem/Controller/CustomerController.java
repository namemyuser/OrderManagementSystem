package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.Customer;
import ios.ordermanagementsystem.Service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping("/hello")
    public String hello() { return "Hello from Customer Controller!"; }

    @GetMapping
    public List<Customer> getAllCustomers() { return customerService.getAllCustomers(); }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) { return customerService.getCustomer(id); }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) { customerService.addCustomer(customer); }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) { customerService.removeCustomer(id); }
}
