package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.ContractLine;
import ios.ordermanagementsystem.Repository.ContractLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractLineService {

    private final ContractLineRepository repository;

    public ContractLineService(ContractLineRepository repository) {
        this.repository = repository;
    }

    public ContractLine addContractLine(ContractLine contractLine) {
        return repository.save(contractLine);
    }

    public ContractLine getContractLine(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ContractLine> getAllContractLines() {
        return repository.findAll();
    }

    public void removeContractLine(Long id) {
        repository.deleteById(id);
    }
}
