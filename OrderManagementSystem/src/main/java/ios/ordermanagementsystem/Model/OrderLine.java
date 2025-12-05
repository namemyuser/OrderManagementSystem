package ios.ordermanagementsystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_lines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitOfMeasure unit;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;   // can stay null for now if you are not linking yet

    private double quantity;

    public OrderLine() {
    }

    // convenient constructor without order (you can keep the old one too)
    public OrderLine(Product product, UnitOfMeasure unit, double quantity) {
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public UnitOfMeasure getUnit() { return unit; }
    public void setUnit(UnitOfMeasure unit) { this.unit = unit; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
}
