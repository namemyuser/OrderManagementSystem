package ios.ordermanagementsystem.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "contract_type_id")
    private ContractType contractType;

    private String status;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContractLine> contractLines = new ArrayList<>();

    public Contract() {
    }

    public Contract(String name, ContractType contractType, String status) {
        this.name = name;
        this.contractType = contractType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ContractType getContractType() {
        return contractType;
    }
    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractLine> getContractLines() {
        return contractLines;
    }
    public void setContractLines(List<ContractLine> contractLines) {
        this.contractLines = contractLines;
    }
}
