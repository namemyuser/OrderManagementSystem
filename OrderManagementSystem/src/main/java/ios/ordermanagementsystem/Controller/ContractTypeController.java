package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.ContractType;
import ios.ordermanagementsystem.Service.ContractTypeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contracttypes")
public class ContractTypeController {
    private final ContractTypeService contractTypeService;

    public ContractTypeController(ContractTypeService contractTypeService) {
        this.contractTypeService = contractTypeService;
    }

    @GetMapping
    public List<ContractType> getAllContractTypes() {
        return contractTypeService.getAllContractTypes();
    }

    @GetMapping("/{id}")
    public ContractType getContractType(@PathVariable Long id) {
        return contractTypeService.getContractType(id);
    }

    @PostMapping
    public void addContractType(@RequestBody ContractType contractType) {
        contractTypeService.addContractType(contractType);
    }

    @DeleteMapping("/{id}")
    public void deleteContractType(@PathVariable Long id) {
        contractTypeService.removeContractType(id);
    }
}
