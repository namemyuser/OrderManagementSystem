package ios.ordermanagementsystem.Model;

public class ContractLine {
    private String id;
    private String description;
    private Contract contract;
    private Product product;
    private UnitOfMeasure unit;
    private int quantity;

    public ContractLine() {}

    public ContractLine(String id, Contract contract, String description) {
        this.id = id;
        this.contract = contract;
        this.description = description;
    }

    // New constructor matching your code
    public ContractLine(String id, Product product, UnitOfMeasure unit, int quantity) {
        this.id = id;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
    }

    // GETTERS AND SETTERS
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Contract getContract() { return contract; }
    public void setContract(Contract contract) { this.contract = contract; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public UnitOfMeasure getUnit() { return unit; }
    public void setUnit(UnitOfMeasure unit) { this.unit = unit; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
