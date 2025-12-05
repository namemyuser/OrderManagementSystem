package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Contract;
import ios.ordermanagementsystem.Model.ContractType;
import ios.ordermanagementsystem.Service.ContractService;
import ios.ordermanagementsystem.Service.ContractTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractWebController {

    private final ContractService contractService;
    private final ContractTypeService contractTypeService;

    public ContractWebController(ContractService contractService,
                                 ContractTypeService contractTypeService) {
        this.contractService = contractService;
        this.contractTypeService = contractTypeService;
    }

    @GetMapping
    public String index(Model model) {
        List<Contract> contracts = contractService.getAllContracts();
        model.addAttribute("contracts", contracts);
        return "contracts/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractTypes", contractTypeService.getAllContractTypes());
        return "contracts/form";
    }

    @PostMapping
    public String create(@ModelAttribute("contract") Contract contract) {
        // contract.getContractType().getId() will be set from the form
        ContractType type = contractTypeService.getContractType(
                contract.getContractType().getId());
        contract.setContractType(type);
        contractService.addContract(contract);
        return "redirect:/contracts";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        contractService.removeContract(id);
        return "redirect:/contracts";
    }
}
