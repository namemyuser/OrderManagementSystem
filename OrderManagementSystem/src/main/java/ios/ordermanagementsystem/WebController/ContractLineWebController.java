package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.ContractLine;
import ios.ordermanagementsystem.Model.Contract;
import ios.ordermanagementsystem.Service.ContractLineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contractlines")
public class ContractLineWebController {
    private final ContractLineService contractLineService;
    public ContractLineWebController(ContractLineService contractLineService) {
        this.contractLineService = contractLineService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("contractlines", contractLineService.getAllContractLines());
        return "contractlines/index";
    }
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("contractline", new ContractLine());
        return "contractlines/form";
    }
    @PostMapping
    public String create(
            @RequestParam String id,
            @RequestParam String contract,
            @RequestParam String description
    ) {
        Contract contractObj = new Contract(contract, null);
        ContractLine contractLine = new ContractLine();
        contractLine.setId(id);
        contractLine.setDescription(description);
        contractLine.setContract(contractObj);
        contractLineService.addContractLine(contractLine);
        return "redirect:/contractlines";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        contractLineService.removeContractLine(id);
        return "redirect:/contractlines";
    }
}
