import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Product> products;
    private List<Customer> customers;

    public Store() {
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
        System.out.println("Product " + name + " added to the store.");
    }

    public void addCustomer(String name, double balance) {
        Customer customer = new Customer(name, balance);
        customers.add(customer);
        System.out.println("Customer " + name + " added to the store.");
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void displaySoldProducts() {
        double totalSales = 0;
        for (Customer customer : customers) {
            for (Product product : customer.getPurchasedProducts()) {
                totalSales += product.getPrice();
            }
        }
        System.out.println("Total cost of items sold: " + totalSales);
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add user");
            System.out.println("2. Show list of products");
            System.out.println("3. Select product to purchase");
            System.out.println("4. Show a list of purchased items for the selected user");
            System.out.println("5. Show list of customers");
            System.out.println("6. Add money to user");
            System.out.println("7. Add product to store");
            System.out.println("8. Always display the cost of all items sold");
            System.out.println("0. Exit");

            System.out.print("Select menu item: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    buyProduct();
                    break;
                case 4:
                    showPurchasedProducts();
                    break;
                case 5:
                    showCustomers();
                    break;
                case 6:
                    addMoneyToCustomer();
                    break;
                case 7:
                    addProduct();
                    break;
                case 8:
                    displaySoldProducts();
                    break;
                case 0:
                    System.out.println("Exit the program.");
                    break;
                default:
                    System.out.println("Invalid selection. Please enter a valid menu item.");
            }
        } while (choice != 0);
    }

    private void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = scanner.next();
        System.out.print("Enter user balance: ");
        double balance = scanner.nextDouble();
        addCustomer(name, balance);
    }

    private void showProducts() {
        System.out.println("List of products:");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    private void buyProduct() {
        Customer customer = chooseCustomer();
        if (customer != null) {
            showProducts();
            System.out.print("Enter the name of the product you want to buy: ");
            String productName = new Scanner(System.in).next();
            Product product = findProduct(productName);
            if (product != null) {
                customer.purchaseProduct(product);
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    private void showPurchasedProducts() {
        Customer customer = chooseCustomer();
        if (customer != null) {
            showPurchasedProducts(customer);
        }
    }

    private void showPurchasedProducts(Customer customer) {
        List<Product> purchasedProducts = customer.getPurchasedProducts();
        System.out.println("List of purchased items for " + customer.getName() + ":");
        for (Product product : purchasedProducts) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    private void showCustomers() {
        System.out.println("List of customers:");
        for (Customer customer : customers) {
            System.out.println(customer.getName() + " - " + customer.getBalance());
        }
    }

    private void addMoneyToCustomer() {
        Customer customer = chooseCustomer();
        if (customer != null) {
            System.out.print("Enter the amount to add to your balance: ");
            double amount = new Scanner(System.in).nextDouble();
            customer.addBalance(amount);
            System.out.println("Added " + amount + " money to user " + customer.getName() + ".");
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = new Scanner(System.in).next();
        System.out.print("Enter the price of the product: ");
        double price = new Scanner(System.in).nextDouble();
        addProduct(name, price);
    }

    private Customer chooseCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("List of customers:");
        for (Customer customer : customers) {
            System.out.println(customer.getName() + " - " + customer.getBalance());
        }
        System.out.print("Select user: ");
        String selectedUser = scanner.next();
        return findCustomer(selectedUser);
    }

    private Customer findCustomer(String userName) {
        for (Customer customer : customers) {
            if (customer.getName().equals(userName)) {
                return customer;
            }
        }
        System.out.println("Buyer not found.");
        return null;
    }

    private Product findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        System.out.println("Product is not found.");
        return null;
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.showMenu();
    }
}
