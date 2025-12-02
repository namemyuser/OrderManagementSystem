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

    public void addContractType(ContractType contractType) {
        contractTypeRepository.save(contractType);
    }

    public ContractType getContractType(String id) {
        return contractTypeRepository.findById(id);
    }

    public List<ContractType> getAllContractTypes() {
        return contractTypeRepository.findAll();
    }

    public void removeContractType(String id) {
        contractTypeRepository.deleteById(id);
    }
}

