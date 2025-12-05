package ios.ordermanagementsystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends SellableItem {

    private String status;

    public Product() {
        super();
    }

    public Product(String name, String status) {
        super(name);          // SellableItem(String name)
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
