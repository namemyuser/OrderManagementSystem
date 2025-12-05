package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.UnitOfMeasure;
import ios.ordermanagementsystem.Service.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/units")
public class UnitOfMeasureWebController {
    private final UnitOfMeasureService unitOfMeasureService;
    public UnitOfMeasureWebController(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("units", unitOfMeasureService.getAllUnits());
        return "units/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("unit", new UnitOfMeasure());
        return "units/form";
    }

    @PostMapping
    public String create(@ModelAttribute UnitOfMeasure unit) {
        unitOfMeasureService.addUnit(unit);
        return "redirect:/units";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        unitOfMeasureService.removeUnit(id);
        return "redirect:/units";
    }
}
