import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String address;
    private ArrayList<Table> tables;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.tables = new ArrayList<Table>();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<Table> getTables() {
        return this.tables;
    }

    public void addTable(Table newTable) {
        tables.add(newTable);
    }
}