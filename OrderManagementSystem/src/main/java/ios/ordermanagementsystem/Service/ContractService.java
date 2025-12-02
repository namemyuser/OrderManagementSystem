package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.Contract;
import ios.ordermanagementsystem.Repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractService {
    private final ContractRepository contractRepository;

    public ContractService(ContractRepository repo) {
        this.contractRepository = repo;
    }

    public void addContract(Contract contract) {
        contractRepository.save(contract);
    }

    public Contract getContract(String id) {
        return contractRepository.findById(id);
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public void removeContract(String id) {
        contractRepository.delete(id);
    }
}

