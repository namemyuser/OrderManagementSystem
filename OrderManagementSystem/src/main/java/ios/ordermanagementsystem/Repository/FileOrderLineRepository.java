package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.OrderLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileOrderLineRepository extends InFileRepository<OrderLine>
        implements OrderLineRepository {

    public FileOrderLineRepository() {
        // JSON file: src/main/resources/data/orderLine.json
        super(OrderLine.class, "orderLine.json",
                OrderLine::getId, OrderLine::setId);
    }

    @Override
    public List<OrderLine> findAll() {
        return findAllInternal();
    }

    @Override
    public OrderLine findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public OrderLine save(OrderLine orderLine) {
        return saveInternal(orderLine);
    }

    @Override
    public void update(OrderLine orderLine) {
        updateInternal(orderLine);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }
}
