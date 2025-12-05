package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.ContractLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractLineRepository extends JpaRepository<ContractLine, Long> {
}