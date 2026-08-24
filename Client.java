import java.util.ArrayList;

public class Client {
    private String name;
    private String phone;
    private ArrayList<Order> orders;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.orders = new ArrayList<Order>();
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}