package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Repository.CustomerRepository;
import ios.ordermanagementsystem.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repo) {
        this.customerRepository = repo;
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomer(String id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void removeCustomer(String id) {
        customerRepository.deleteById(id);
    }


}
