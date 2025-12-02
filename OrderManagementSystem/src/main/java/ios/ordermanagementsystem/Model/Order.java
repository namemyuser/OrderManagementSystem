package ios.ordermanagementsystem.Model;

public class Order {
    private String id;
    private String product;
    private String unit;
    private int quantity;
    private Customer customer;

    public Order() {}

    public Order(String id, String product, String unit, int quantity, Customer customer) {
        this.id = id;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.customer = customer;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
