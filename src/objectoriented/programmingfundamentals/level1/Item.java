package objectoriented.programmingfundamentals.level1;

import java.util.Scanner;

public class Item {
    private String itemCode;
    private String itemName;
    private double price;

    public Item() {
    }

    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Item Code: ");
        String itemCode = scanner.nextLine();

        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter Item Price: ");
        double price = scanner.nextDouble();

        Item item = new Item(itemCode, itemName, price);

        System.out.println("\n--- Item Details ---");
        item.displayDetails();

        scanner.close();
    }
}
