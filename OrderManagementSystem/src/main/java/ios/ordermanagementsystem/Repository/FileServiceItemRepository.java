package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ServiceItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileServiceItemRepository extends InFileRepository<ServiceItem>
        implements ServiceItemRepository {

    public FileServiceItemRepository() {
        // JSON file: src/main/resources/data/serviceItem.json
        super(ServiceItem.class, "serviceItem.json",
                ServiceItem::getId, ServiceItem::setId);
    }

    @Override
    public List<ServiceItem> findAll() {
        return findAllInternal();
    }

    @Override
    public ServiceItem findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public ServiceItem save(ServiceItem serviceItem) {
        return saveInternal(serviceItem);
    }

    @Override
    public void update(ServiceItem serviceItem) {
        updateInternal(serviceItem);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }
}
