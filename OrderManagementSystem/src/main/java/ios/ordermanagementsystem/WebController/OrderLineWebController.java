package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Order;
import ios.ordermanagementsystem.Model.OrderLine;
import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Model.UnitOfMeasure;
import ios.ordermanagementsystem.Service.OrderLineService;
import ios.ordermanagementsystem.Repository.OrderRepository;
import ios.ordermanagementsystem.Repository.ProductRepository;
import ios.ordermanagementsystem.Repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orderlines")
public class OrderLineWebController {

    private final OrderLineService orderLineService;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UnitOfMeasureRepository unitRepository;

    public OrderLineWebController(OrderLineService orderLineService,
                                  OrderRepository orderRepository,
                                  ProductRepository productRepository,
                                  UnitOfMeasureRepository unitRepository) {
        this.orderLineService = orderLineService;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("orderlines", orderLineService.getAllOrderLines());
        return "orderlines/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("orderline", new OrderLine());
        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("units", unitRepository.findAll());
        return "orderlines/form";
    }

    @PostMapping
    public String create(@RequestParam Long orderId,
                         @RequestParam Long productId,
                         @RequestParam Long unitId,
                         @RequestParam double quantity) {

        Order order = orderRepository.findById(orderId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        UnitOfMeasure unit = unitRepository.findById(unitId).orElse(null);

        if (order == null || product == null || unit == null) {
            return "redirect:/orderlines/new";
        }

        OrderLine orderLine = new OrderLine(product, unit, quantity);
        orderLine.setOrder(order);  // ensure order_id is not null

        orderLineService.addOrderLine(orderLine);
        return "redirect:/orderlines";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        orderLineService.removeOrderLine(id);
        return "redirect:/orderlines";
    }
}
