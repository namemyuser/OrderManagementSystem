package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.SellableItem;
import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Model.ServiceItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellableItemService {

    private final ProductService productService;
    private final ServiceItemService serviceItemService;

    public SellableItemService(ProductService productService,
                               ServiceItemService serviceItemService) {
        this.productService = productService;
        this.serviceItemService = serviceItemService;
    }

    /**
     * Returns all sellable items (products + service items) in one list.
     */
    public List<SellableItem> getAllItems() {
        List<SellableItem> result = new ArrayList<>();
        List<Product> products = productService.getAllItems();
        List<ServiceItem> services = serviceItemService.getAllItems();
        result.addAll(products);
        result.addAll(services);
        return result;
    }
}
