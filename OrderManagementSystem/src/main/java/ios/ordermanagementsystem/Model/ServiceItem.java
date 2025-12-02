package ios.ordermanagementsystem.Model;

public class ServiceItem extends SellableItem {
    private String description;

    public ServiceItem() {}
    public ServiceItem(String id, String name, String description) {
        super(id, name); // Only pass id and name
        this.description = description;
    }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
