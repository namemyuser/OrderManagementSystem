package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ContractType;

import java.util.List;

public interface ContractTypeRepository {

    List<ContractType> findAll();

    ContractType findById(String id);

    ContractType save(ContractType contractType);

    void update(ContractType contractType);

    void deleteById(String id);

}
