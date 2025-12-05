package ios.ordermanagementsystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_items")
public class ServiceItem extends SellableItem {

    private String description;

    public ServiceItem() {
        super();
    }

    public ServiceItem(String name, String description) {
        super(name);              // SellableItem(String name)
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
