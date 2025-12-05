package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
