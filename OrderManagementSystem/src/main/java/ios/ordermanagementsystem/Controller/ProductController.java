package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllItems();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getItem(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addItem(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.removeItem(id);
    }
}
