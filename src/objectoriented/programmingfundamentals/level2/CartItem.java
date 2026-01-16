package objectoriented.programmingfundamentals.level2;

import java.util.Scanner;

public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem() {
    }

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateItemTotal() {
        return price * quantity;
    }

    public void displayItemDetails() {
        System.out.printf("%-20s $%-10.2f %-10d $%.2f\n", itemName, price, quantity, calculateItemTotal());
    }

    public static double calculateCartTotal(CartItem[] items) {
        double total = 0;
        for (CartItem item : items) {
            if (item != null) {
                total += item.calculateItemTotal();
            }
        }
        return total;
    }

    public static void displayCart(CartItem[] items) {
        System.out.println("\n--- Shopping Cart ---");
        System.out.printf("%-20s %-11s %-10s %s\n", "Item Name", "Price", "Quantity", "Total");
        System.out.println("-".repeat(55));

        for (CartItem item : items) {
            if (item != null) {
                item.displayItemDetails();
            }
        }

        System.out.println("-".repeat(55));
        System.out.printf("%-41s $%.2f\n", "Cart Total:", calculateCartTotal(items));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items to add to cart: ");
        int numberOfItems = scanner.nextInt();
        scanner.nextLine();

        CartItem[] cart = new CartItem[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("Enter Item Name: ");
            String itemName = scanner.nextLine();

            System.out.print("Enter Item Price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            cart[i] = new CartItem(itemName, price, quantity);
        }

        displayCart(cart);

        scanner.close();
    }
}
