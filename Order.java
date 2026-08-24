import java.util.ArrayList;

public class Order {
    private int number;
    private Client client;
    private ArrayList<OrderDetail> details;

    public Order(int number, Client client) {
        this.number = number;
        this.client = client;
        this.details = new ArrayList<OrderDetail>();

        client.addOrder(this);
    }

    public int getNumber() {
        return this.number;
    }

    public Client getClient() {
        return this.client;
    }

    public ArrayList<OrderDetail> getDetails() {
        return this.details;
    }

    public void addProduct(Product product, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be bigger than 0");
        }

        OrderDetail detail = new OrderDetail(product, quantity);
        details.add(detail);
    }

    public double calculateTotal() {
        double total = 0;

        for (OrderDetail detail : details) {
            total += detail.calculateSubtotal();
        }

        return total;
    }
}