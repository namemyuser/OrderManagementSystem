package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileOrderRepository extends InFileRepository<Order>
        implements OrderRepository {

    public FileOrderRepository() {
        // JSON file: src/main/resources/data/order.json
        super(Order.class, "order.json", Order::getId, Order::setId);
    }

    @Override
    public List<Order> findAll() {
        return findAllInternal();
    }

    @Override
    public Order findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public Order save(Order order) {
        return saveInternal(order);
    }

    @Override
    public void update(Order order) {
        updateInternal(order);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }
}
