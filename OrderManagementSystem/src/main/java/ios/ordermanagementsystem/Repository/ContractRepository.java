package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
