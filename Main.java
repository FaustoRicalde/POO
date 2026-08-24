public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(
                "Burger Shot",
                "Av. Pedregal #916"
        );

        Table table1 = new Table(1, 4);
        Table table2 = new Table(2, 6);

        restaurant.addTable(table1);
        restaurant.addTable(table2);

        Product hamburger = new Product("Hamburger", 85.00);
        Product soda = new Product("Pepsi", 25.00);
        Product fries = new Product("French Fries", 40.00);

        Client client = new Client(
                "Ana Jimenez",
                "(443)5282943"
        );

        Order order = new Order(1001, client);

        order.addProduct(hamburger, 2);
        order.addProduct(soda, 2);
        order.addProduct(fries, 1);

        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Address: " + restaurant.getAddress());

        System.out.println("Client: " + client.getName());
        System.out.println("Phone: " + client.getPhone());

        System.out.println("Order: " + order.getNumber());

        for (OrderDetail detail : order.getDetails()) {
            System.out.println(detail.getProduct().getName() + " x" + detail.getQuantity() + " = $" + detail.calculateSubtotal());
        }

        System.out.println("Total: ¢" + order.calculateTotal());
    }
}