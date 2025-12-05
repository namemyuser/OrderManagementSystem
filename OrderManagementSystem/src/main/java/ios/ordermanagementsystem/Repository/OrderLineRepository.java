package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
