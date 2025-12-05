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

    public Contract addContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public Contract getContract(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public void removeContract(Long id) {
        contractRepository.deleteById(id);
    }
}
