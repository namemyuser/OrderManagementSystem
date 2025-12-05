package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
