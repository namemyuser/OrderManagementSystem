package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.ServiceItem;
import ios.ordermanagementsystem.Repository.ServiceItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceItemService {
    private final ServiceItemRepository repository;
    public ServiceItemService(ServiceItemRepository repository) { this.repository = repository; }
    public void addItem(ServiceItem item) { repository.save(item); }
    public ServiceItem getItem(String id) { return repository.findById(id); }
    public List<ServiceItem> getAllItems() { return repository.findAll(); }
    public void removeItem(String id) { repository.deleteById(id); }
}
