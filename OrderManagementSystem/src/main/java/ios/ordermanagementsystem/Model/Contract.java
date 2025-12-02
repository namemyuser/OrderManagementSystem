package ios.ordermanagementsystem.Model;

import java.util.List;

public class Contract {
    private String id;
    private String name;
    private ContractType contractType;
    private String status;
    private List<ContractLine> contractLines;

    public Contract(String id, String name, ContractType contractType, String status) {
        this.id = id;
        this.name = name;
        this.contractType = contractType;
        this.status = status;
    }
    public Contract() {}

    public Contract(String contract, Object o) {
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ContractType getContractType() { return contractType; }
    public void setContractType(ContractType contractType) { this.contractType = contractType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<ContractLine> getContractLines() { return contractLines; }
    public void setContractLines(List<ContractLine> contractLines) { this.contractLines = contractLines; }
}
