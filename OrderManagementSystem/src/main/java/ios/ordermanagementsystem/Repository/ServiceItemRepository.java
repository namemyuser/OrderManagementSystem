package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
}
