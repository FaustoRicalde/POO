public class OrderDetail {
    private Product product;
    private int quantity;
    private double price;

    public OrderDetail(Product product, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be bigger than 0");
        }

        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public double calculateSubtotal() {
        return quantity * price;
    }
}
