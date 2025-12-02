package ios.ordermanagementsystem.Model;

public class Customer {
    private String id;
    private String name;
    private String currency;

    public Customer() {}

    public Customer(String id, String name, String currency) {
        this.id = id;
        this.name = name;
        this.currency = currency;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
