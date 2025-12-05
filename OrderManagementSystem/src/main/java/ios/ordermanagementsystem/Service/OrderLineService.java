package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.OrderLine;
import ios.ordermanagementsystem.Repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    private final OrderLineRepository repository;

    public OrderLineService(OrderLineRepository repository) {
        this.repository = repository;
    }

    public OrderLine addOrderLine(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    public OrderLine getOrderLine(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<OrderLine> getAllOrderLines() {
        return repository.findAll();
    }

    public void removeOrderLine(Long id) {
        repository.deleteById(id);
    }
}
