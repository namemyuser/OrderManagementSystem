package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.UnitOfMeasure;
import ios.ordermanagementsystem.Service.UnitOfMeasureService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitOfMeasureController {
    private final UnitOfMeasureService service;
    public UnitOfMeasureController(UnitOfMeasureService service) { this.service = service; }

    @GetMapping
    public List<UnitOfMeasure> getAllUnits() { return service.getAllUnits(); }

    @GetMapping("/{id}")
    public UnitOfMeasure getUnit(@PathVariable Long id) { return service.getUnit(id); }

    @PostMapping
    public void addUnit(@RequestBody UnitOfMeasure unit) { service.addUnit(unit); }

    @DeleteMapping("/{id}")
    public void deleteUnit(@PathVariable Long id) { service.removeUnit(id); }
}

