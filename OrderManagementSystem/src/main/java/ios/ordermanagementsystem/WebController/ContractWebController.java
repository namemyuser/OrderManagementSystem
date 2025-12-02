package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.Contract;
import ios.ordermanagementsystem.Service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contracts")
public class ContractWebController {
    private final ContractService contractService;

    public ContractWebController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("contracts", contractService.getAllContracts());
        return "contracts/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contracts/form";
    }

    @PostMapping
    public String create(@ModelAttribute Contract contract) {
        contractService.addContract(contract);
        return "redirect:/contracts";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        contractService.removeContract(id);
        return "redirect:/contracts";
    }
}
