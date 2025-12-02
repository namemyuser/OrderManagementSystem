package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.ContractLine;
import ios.ordermanagementsystem.Service.ContractLineService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contractlines")
public class ContractLineController {
    private final ContractLineService contractLineService;

    public ContractLineController(ContractLineService contractLineService) {
        this.contractLineService = contractLineService;
    }

    @GetMapping
    public List<ContractLine> getAllContractLines() {
        return contractLineService.getAllContractLines();
    }


}
