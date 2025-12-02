package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findById(String id);

    Customer save(Customer customer);

    void update(Customer customer);

    void deleteById(String id);

}
