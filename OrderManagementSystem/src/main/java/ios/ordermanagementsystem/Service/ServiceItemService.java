package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.ServiceItem;
import ios.ordermanagementsystem.Repository.ServiceItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceItemService {

    private final ServiceItemRepository repository;

    public ServiceItemService(ServiceItemRepository repository) {
        this.repository = repository;
    }

    public ServiceItem addItem(ServiceItem item) {
        return repository.save(item);
    }

    public ServiceItem getItem(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ServiceItem> getAllItems() {
        return repository.findAll();
    }

    public void removeItem(Long id) {
        repository.deleteById(id);
    }
}
