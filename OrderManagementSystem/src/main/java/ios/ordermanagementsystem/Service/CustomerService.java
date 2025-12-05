package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.Customer;
import ios.ordermanagementsystem.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repo) {
        this.customerRepository = repo;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void removeCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
