package ios.ordermanagementsystem.Model;

public class UnitOfMeasure {
    private String id;
    private String name;
    private String abbreviation;

    public UnitOfMeasure() {}

    public UnitOfMeasure(String id, String name, String abbreviation) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
}
