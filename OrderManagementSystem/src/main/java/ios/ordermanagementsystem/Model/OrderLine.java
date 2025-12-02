package ios.ordermanagementsystem.Model;

public class OrderLine {
    private String id;
    private Product product; // Change this to `SellableItem item;` or `Product product;` as needed
    private UnitOfMeasure unit;
    private double quantity;

    public OrderLine() {}
    public OrderLine(String id, Product product, UnitOfMeasure unit, double quantity) {
        this.id = id;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public UnitOfMeasure getUnit() { return unit; }
    public void setUnit(UnitOfMeasure unit) { this.unit = unit; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
}
