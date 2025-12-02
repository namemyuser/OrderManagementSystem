package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductWebController {
    private final ProductService productService;
    public ProductWebController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.getAllItems());
        return "products/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }

    @PostMapping
    public String create(@ModelAttribute Product product) {
        productService.addItem(product);
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        productService.removeItem(id);
        return "redirect:/products";
    }
}
