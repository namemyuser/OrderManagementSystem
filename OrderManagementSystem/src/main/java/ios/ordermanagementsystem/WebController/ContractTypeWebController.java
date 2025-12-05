package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.ContractType;
import ios.ordermanagementsystem.Service.ContractTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contracttypes")
public class ContractTypeWebController {
    private final ContractTypeService contractTypeService;

    public ContractTypeWebController(ContractTypeService contractTypeService) {
        this.contractTypeService = contractTypeService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("contracttypes", contractTypeService.getAllContractTypes());
        return "contracttypes/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("contracttype", new ContractType());
        return "contracttypes/form";
    }

    @PostMapping
    public String create(@ModelAttribute ContractType contractType) {
        contractTypeService.addContractType(contractType);
        return "redirect:/contracttypes";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        contractTypeService.removeContractType(id);
        return "redirect:/contracttypes";
    }
}
