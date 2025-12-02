package ios.ordermanagementsystem.Model;

public class Product extends SellableItem {
    private String status;

    public Product() {}
    public Product(String id, String name, String status) {
        super(id, name); // Only pass id and name to SellableItem constructor!
        this.status = status;
    }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
