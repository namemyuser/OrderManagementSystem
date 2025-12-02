package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.ContractLine;
import ios.ordermanagementsystem.Repository.ContractLineRepository;
import ios.ordermanagementsystem.Repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractLineService {
    private final ContractLineRepository repository;
    public ContractLineService(ContractLineRepository repository) { this.repository = repository; }
    public void addContractLine(ContractLine contractLine) { repository.save(contractLine); }
    public ContractLine getContractLine(String id) { return repository.findById(id); }
    public List<ContractLine> getAllContractLines() { return repository.findAll(); }
    public void removeContractLine(String id) { repository.delete(id); }

}
