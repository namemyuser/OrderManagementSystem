package ios.ordermanagementsystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "contract_lines")
public class ContractLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitOfMeasure unit;

    private int quantity;

    public ContractLine() {
    }

    public ContractLine(Contract contract, String description) {
        this.contract = contract;
        this.description = description;
    }

    public ContractLine(Product product, UnitOfMeasure unit, int quantity, Contract contract) {
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Contract getContract() {
        return contract;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public UnitOfMeasure getUnit() {
        return unit;
    }
    public void setUnit(UnitOfMeasure unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
