package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.OrderLine;
import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Model.UnitOfMeasure;
import ios.ordermanagementsystem.Service.OrderLineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orderlines")
public class OrderLineWebController {
    private final OrderLineService orderLineService;
    public OrderLineWebController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("orderlines", orderLineService.getAllOrderLines());
        return "orderlines/index";
    }
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("orderline", new OrderLine());
        return "orderlines/form";
    }
    @PostMapping
    public String create(
            @RequestParam String id,
            @RequestParam String product,
            @RequestParam String unit,
            @RequestParam double quantity
    ) {
        Product prod = new Product();
        prod.setName(product); // Or prod.setId(product) if you want IDs

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setName(unit); // Or uom.setId(unit)

        OrderLine orderLine = new OrderLine(id, prod, uom, quantity);
        orderLineService.addOrderLine(orderLine);
        return "redirect:/orderlines";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        orderLineService.removeOrderLine(id);
        return "redirect:/orderlines";
    }
}
