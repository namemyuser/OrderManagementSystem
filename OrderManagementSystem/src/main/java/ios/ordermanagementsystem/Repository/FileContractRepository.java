package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileContractRepository extends InFileRepository<Contract> implements ContractRepository {

    public FileContractRepository() {
        // JSON file: src/main/resources/data/contract.json
        super(Contract.class, "contract.json", Contract::getId, Contract::setId);
    }

    @Override
    public List<Contract> findAll() {
        return findAllInternal();
    }

    @Override
    public Contract findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public Contract save(Contract contract) {
        return saveInternal(contract);
    }

    @Override
    public void update(Contract contract) {
        updateInternal(contract);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }

    @Override
    public void delete(String id) {

    }
}
