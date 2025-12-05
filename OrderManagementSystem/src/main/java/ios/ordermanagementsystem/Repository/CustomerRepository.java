package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
