package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.SellableItem;

import java.util.List;

public interface SellableItemRepository {

    List<SellableItem> findAll();

    SellableItem findById(String id);

    SellableItem save(SellableItem item);

    void update(SellableItem item);

    void deleteById(String id);

}
