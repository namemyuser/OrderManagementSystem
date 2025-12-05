package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.SellableItem;
import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Model.ServiceItem;
import ios.ordermanagementsystem.Repository.ProductRepository;
import ios.ordermanagementsystem.Repository.ServiceItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellableItemService {

    private final ProductRepository productRepository;
    private final ServiceItemRepository serviceItemRepository;

    public SellableItemService(ProductRepository productRepository,
                               ServiceItemRepository serviceItemRepository) {
        this.productRepository = productRepository;
        this.serviceItemRepository = serviceItemRepository;
    }

    public List<SellableItem> getAllItems() {
        List<SellableItem> items = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        List<ServiceItem> services = serviceItemRepository.findAll();
        items.addAll(products);
        items.addAll(services);
        return items;
    }
}
