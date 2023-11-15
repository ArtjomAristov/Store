import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private double balance;
    private List<Product> purchasedProducts;
    private int rating;


    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.purchasedProducts = new ArrayList<>();
        this.rating = 0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void addBalance(double amount) {
        balance += amount;
        System.out.println("User " + name + " balance increased by " + amount + ". New balance: " + balance);
    }

    public void purchaseProduct(Product product, int amountBuy) {
        if (balance >= product.getPrice()) {
            purchasedProducts.add(product);
            balance -= product.getPrice() * amountBuy;
            System.out.println(name + " bought " + product.getName() + " for " + product.getPrice() + ". Balance balance: " + balance);
        } else {
            System.out.println(name + " cannot afford to buy " + product.getName() + ". Insufficient funds.");
        }
    }

    public int getRating() {
        return rating;
    }

    public void increaseRating(int amount) {
        rating += amount;
    }
}
