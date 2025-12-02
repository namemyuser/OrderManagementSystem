package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileCustomerRepository extends InFileRepository<Customer>
        implements CustomerRepository {

    public FileCustomerRepository() {
        // JSON file: src/main/resources/data/customer.json
        super(Customer.class, "customer.json",
                Customer::getId, Customer::setId);
    }

    @Override
    public List<Customer> findAll() {
        return findAllInternal();
    }

    @Override
    public Customer findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public Customer save(Customer customer) {
        return saveInternal(customer);
    }

    @Override
    public void update(Customer customer) {
        updateInternal(customer);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }
}
