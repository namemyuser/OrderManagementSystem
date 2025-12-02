package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.OrderLine;
import ios.ordermanagementsystem.Service.OrderLineService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orderlines")
public class OrderLineController {
    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping
    public List<OrderLine> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }
}
