package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Contract;

import java.util.List;

public interface ContractRepository {

    List<Contract> findAll();

    Contract findById(String id);

    Contract save(Contract contract);

    void update(Contract contract);

    void deleteById(String id);

    void delete(String id);
}
