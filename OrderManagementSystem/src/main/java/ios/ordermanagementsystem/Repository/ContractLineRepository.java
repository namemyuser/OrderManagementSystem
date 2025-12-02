package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ContractLine;

import java.util.List;

public interface ContractLineRepository {

    List<ContractLine> findAll();

    ContractLine findById(String id);

    ContractLine save(ContractLine contractLine);

    void update(ContractLine contractLine);

    void deleteById(String id);

    void delete(String id);
}
