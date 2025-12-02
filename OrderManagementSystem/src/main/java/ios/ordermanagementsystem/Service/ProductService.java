package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Add a product
    public void addItem(Product product) {
        productRepository.save(product);
    }

    // Get a product by ID
    public Product getItem(String id) {
        return productRepository.findById(id);
    }

    // Get all products
    public List<Product> getAllItems() {
        return productRepository.findAll();
    }

    // Remove a product by ID
    public void removeItem(String id) {
        productRepository.deleteById(id);
    }
}
