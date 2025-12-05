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
    public Product addItem(Product product) {
        return productRepository.save(product);
    }

    // Get a product by ID
    public Product getItem(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Get all products
    public List<Product> getAllItems() {
        return productRepository.findAll();
    }

    // Remove a product by ID
    public void removeItem(Long id) {
        productRepository.deleteById(id);
    }
}
