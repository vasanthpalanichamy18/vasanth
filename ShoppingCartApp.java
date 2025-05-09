// Basic E-commerce Shopping Cart in Java (Console Version)

import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

public class ShoppingCartApp {
    static List<Product> products = new ArrayList<>();
    static List<CartItem> cart = new ArrayList<>();

    public static void main(String[] args) {
        initProducts();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> addToCart(sc);
                case 3 -> viewCart();
                case 4 -> checkout();
                case 5 -> System.out.println("Thank you for shopping!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }

    static void initProducts() {
        products.add(new Product(1, "Laptop", 45000));
        products.add(new Product(2, "Smartphone", 15000));
        products.add(new Product(3, "Headphones", 2000));
        products.add(new Product(4, "Charger", 500));
    }

    static void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.println(p.id + ". " + p.name + " - Rs." + p.price);
        }
    }

    static void addToCart(Scanner sc) {
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();
        Product selected = null;
        for (Product p : products) {
            if (p.id == id) {
                selected = p;
                break;
            }
        }
        if (selected == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        cart.add(new CartItem(selected, qty));
        System.out.println("Added to cart!");
    }

    static void viewCart() {
        System.out.println("\nYour Cart:");
        double total = 0;
        for (CartItem item : cart) {
            double subtotal = item.product.price * item.quantity;
            System.out.println(item.product.name + " x " + item.quantity + " = Rs." + subtotal);
            total += subtotal;
        }
        System.out.println("Total: Rs." + total);
    }

    static void checkout() {
        viewCart();
        cart.clear();
        System.out.println("Checkout complete. Order placed!");
    }
}
