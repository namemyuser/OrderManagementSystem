package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.ServiceItem;
import ios.ordermanagementsystem.Service.ServiceItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/serviceitems")
public class ServiceItemWebController {
    private final ServiceItemService serviceItemService;
    public ServiceItemWebController(ServiceItemService serviceItemService) { this.serviceItemService = serviceItemService; }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("serviceitems", serviceItemService.getAllItems());
        return "serviceitems/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("serviceitem", new ServiceItem());
        return "serviceitems/form";
    }

    @PostMapping
    public String create(@ModelAttribute ServiceItem serviceItem) {
        serviceItemService.addItem(serviceItem);
        return "redirect:/serviceitems";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        serviceItemService.removeItem(id);
        return "redirect:/serviceitems";
    }
}
