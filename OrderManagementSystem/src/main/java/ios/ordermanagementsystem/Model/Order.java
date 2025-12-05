package ios.ordermanagementsystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // maps to orders.name (NOT NULL in DB)
    private String name;

    // simple text fields, not FKs
    private String product;
    private String unit;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")   // FK column in orders table
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = true)
    private Contract contract;          // optional

    public Order() {
    }

    public Order(String name, String product, String unit, int quantity, Customer customer) {
        this.name = name;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.customer = customer;
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

    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contract getContract() {
        return contract;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
