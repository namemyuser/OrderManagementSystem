package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ContractLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileContractLineRepository extends InFileRepository<ContractLine>
        implements ContractLineRepository {

    public FileContractLineRepository() {
        // JSON file: src/main/resources/data/contractLine.json
        super(ContractLine.class, "contractLine.json",
                ContractLine::getId, ContractLine::setId);
    }

    @Override
    public List<ContractLine> findAll() {
        return findAllInternal();
    }

    @Override
    public ContractLine findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public ContractLine save(ContractLine contractLine) {
        return saveInternal(contractLine);
    }

    @Override
    public void update(ContractLine contractLine) {
        updateInternal(contractLine);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }

    @Override
    public void delete(String id) {

    }
}
