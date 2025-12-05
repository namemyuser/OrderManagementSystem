package ios.ordermanagementsystem.WebController;

import ios.ordermanagementsystem.Model.ContractLine;
import ios.ordermanagementsystem.Model.Contract;
import ios.ordermanagementsystem.Model.Product;
import ios.ordermanagementsystem.Model.UnitOfMeasure;
import ios.ordermanagementsystem.Service.ContractLineService;
import ios.ordermanagementsystem.Service.ContractService;
import ios.ordermanagementsystem.Service.ProductService;
import ios.ordermanagementsystem.Service.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contractlines")
public class ContractLineWebController {

    private final ContractLineService contractLineService;
    private final ContractService contractService;
    private final ProductService productService;
    private final UnitOfMeasureService unitService;

    public ContractLineWebController(ContractLineService contractLineService,
                                     ContractService contractService,
                                     ProductService productService,
                                     UnitOfMeasureService unitService) {
        this.contractLineService = contractLineService;
        this.contractService = contractService;
        this.productService = productService;
        this.unitService = unitService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("contractlines", contractLineService.getAllContractLines());
        return "contractlines/index";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("contractline", new ContractLine());
        model.addAttribute("contracts", contractService.getAllContracts());
        model.addAttribute("products", productService.getAllItems());
        model.addAttribute("units", unitService.getAllUnits());
        return "contractlines/form";
    }

    @PostMapping
    public String create(@RequestParam Long contractId,
                         @RequestParam Long productId,
                         @RequestParam Long unitId,
                         @RequestParam int quantity,
                         @RequestParam String description) {

        Contract contract = contractService.getContract(contractId);
        Product product = productService.getItem(productId);
        UnitOfMeasure unit = unitService.getUnit(unitId);

        if (contract == null || product == null || unit == null) {
            return "redirect:/contractlines/new";
        }

        ContractLine contractLine = new ContractLine();
        contractLine.setContract(contract);
        contractLine.setProduct(product);
        contractLine.setUnit(unit);       // ensures unit_id is not null
        contractLine.setQuantity(quantity);
        contractLine.setDescription(description);

        contractLineService.addContractLine(contractLine);
        return "redirect:/contractlines";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        contractLineService.removeContractLine(id);
        return "redirect:/contractlines";
    }
}
