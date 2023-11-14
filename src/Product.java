public class Product {
    private int amount;
    private String name;
    private double price;

    public Product(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public boolean changeAmount() {
        if (amount > 0) {
            amount--;
            return true;
        }
        return false;
    }
}

