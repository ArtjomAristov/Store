public class Product {
    private int amount;
    private String name;
    private double price;
    private int popularity;

    public Product(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.popularity = 0;
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

    public void setAmount(int newAmount) {
        this.amount = newAmount;

    }

    public boolean changeAmount() {
        if (amount > 0) {
            amount--;
            return true;
        }
        return false;
    }
    public int getPopularity() {
        return popularity;
    }

    public void increasePopularity(int amount){
        popularity += amount;
    }
}

