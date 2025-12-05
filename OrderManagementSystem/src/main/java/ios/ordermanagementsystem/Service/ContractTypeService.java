package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.ContractType;
import ios.ordermanagementsystem.Repository.ContractTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeService {

    private final ContractTypeRepository contractTypeRepository;

    public ContractTypeService(ContractTypeRepository repo) {
        this.contractTypeRepository = repo;
    }

    public ContractType addContractType(ContractType contractType) {
        return contractTypeRepository.save(contractType);
    }

    public ContractType getContractType(Long id) {
        return contractTypeRepository.findById(id).orElse(null);
    }

    public List<ContractType> getAllContractTypes() {
        return contractTypeRepository.findAll();
    }

    public void removeContractType(Long id) {
        contractTypeRepository.deleteById(id);
    }
}
