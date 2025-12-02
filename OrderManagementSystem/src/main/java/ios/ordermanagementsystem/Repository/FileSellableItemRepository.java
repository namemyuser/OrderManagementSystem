package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.SellableItem;
import org.springframework.stereotype.Repository;

import java.util.List;


public class FileSellableItemRepository extends InFileRepository<SellableItem>
        implements SellableItemRepository {

    public FileSellableItemRepository() {
        // JSON file: src/main/resources/data/sellableItem.json
        super(SellableItem.class, "sellableItem.json",
                SellableItem::getId, SellableItem::setId);
    }

    @Override
    public List<SellableItem> findAll() {
        return findAllInternal();
    }

    @Override
    public SellableItem findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public SellableItem save(SellableItem item) {
        return saveInternal(item);
    }

    @Override
    public void update(SellableItem item) {
        updateInternal(item);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }
}
