package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Customer;
import ios.ordermanagementsystem.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerWebController {

    private final CustomerService customerService;

    public CustomerWebController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    @PostMapping
    public String create(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {   // Long to match JPA id
        customerService.removeCustomer(id);
        return "redirect:/customers";
    }
}
