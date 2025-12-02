package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.OrderLine;
import ios.ordermanagementsystem.Repository.OrderLineRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderLineService {
    private final OrderLineRepository repository;
    public OrderLineService(OrderLineRepository repository) { this.repository = repository; }
    public void addOrderLine(OrderLine orderLine) { repository.save(orderLine); }
    public OrderLine getOrderLine(String id) { return repository.findById(id); }
    public List<OrderLine> getAllOrderLines() { return repository.findAll(); }
    public void removeOrderLine(String id) { repository.deleteById(id); }
}
