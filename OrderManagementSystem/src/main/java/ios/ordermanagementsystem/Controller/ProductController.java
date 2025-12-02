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
    public Product getProduct(@PathVariable String id) {
        return productService.getItem(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addItem(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.removeItem(id);
    }
}
