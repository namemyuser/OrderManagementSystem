package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ServiceItem;

import java.util.List;

public interface ServiceItemRepository {

    List<ServiceItem> findAll();

    ServiceItem findById(String id);

    ServiceItem save(ServiceItem serviceItem);

    void update(ServiceItem serviceItem);

    void deleteById(String id);

}
