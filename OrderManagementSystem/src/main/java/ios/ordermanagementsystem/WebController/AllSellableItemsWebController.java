package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Model.ServiceItem;
import ios.ordermanagementsystem.Service.ProductService;
import ios.ordermanagementsystem.Service.ServiceItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/allsellableitems")
public class AllSellableItemsWebController {
    private final ProductService productService;
    private final ServiceItemService serviceItemService;
    public AllSellableItemsWebController(ProductService productService, ServiceItemService serviceItemService) {
        this.productService = productService;
        this.serviceItemService = serviceItemService;
    }

    @GetMapping
    public String index(Model model) {
        List<Product> products = productService.getAllItems();
        List<ServiceItem> serviceItems = serviceItemService.getAllItems();
        model.addAttribute("products", products);
        model.addAttribute("serviceItems", serviceItems);
        return "allsellableitems/index";
    }
}
