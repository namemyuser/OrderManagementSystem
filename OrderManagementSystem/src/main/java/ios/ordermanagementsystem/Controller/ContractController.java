package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.Contract;
import ios.ordermanagementsystem.Service.ContractService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
    private final ContractService service;
    public ContractController(ContractService service) { this.service = service; }

    @GetMapping
    public List<Contract> getAllContracts() { return service.getAllContracts(); }

    @GetMapping("/{id}")
    public Contract getContract(@PathVariable Long id) { return service.getContract(id); }

    @PostMapping
    public void addContract(@RequestBody Contract contract) { service.addContract(contract); }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) { service.removeContract(id); }
}

