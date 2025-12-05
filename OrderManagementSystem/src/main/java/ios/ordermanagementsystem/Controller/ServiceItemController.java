package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.ServiceItem;
import ios.ordermanagementsystem.Service.ServiceItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/serviceitems")
public class ServiceItemController {
    private final ServiceItemService serviceItemService;

    public ServiceItemController(ServiceItemService serviceItemService) {
        this.serviceItemService = serviceItemService;
    }

    @GetMapping
    public List<ServiceItem> getAllServiceItems() {
        return serviceItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ServiceItem getServiceItem(@PathVariable Long id) {
        return serviceItemService.getItem(id);
    }

    @PostMapping
    public void addServiceItem(@RequestBody ServiceItem serviceItem) {
        serviceItemService.addItem(serviceItem);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceItem(@PathVariable Long id) {
        serviceItemService.removeItem(id);
    }
}
