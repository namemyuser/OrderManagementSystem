package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ContractType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileContractTypeRepository extends InFileRepository<ContractType>
        implements ContractTypeRepository {

    public FileContractTypeRepository() {
        // JSON file: src/main/resources/data/contractType.json
        super(ContractType.class, "contractType.json",
                ContractType::getId, ContractType::setId);
    }

    @Override
    public List<ContractType> findAll() {
        return findAllInternal();
    }

    @Override
    public ContractType findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public ContractType save(ContractType contractType) {
        return saveInternal(contractType);
    }

    @Override
    public void update(ContractType contractType) {
        updateInternal(contractType);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }
}
