package datastructures.linkedlist.singlylinkedlist;

import java.util.Scanner;

public class InventoryManagement {

    private ItemNode head;
    private int size;

    private static class ItemNode {
        String itemName;
        int itemId;
        int quantity;
        double price;
        ItemNode next;

        ItemNode(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    public InventoryManagement() {
        this.head = null;
        this.size = 0;
    }

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Item added at beginning.");
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Item added at end.");
    }

    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        ItemNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Item added at position " + position + ".");
    }

    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            size--;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        ItemNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            current.next = current.next.next;
            size--;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId + ".");
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchByItemId(int itemId) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item found:");
                displayItem(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchByItemName(String itemName) {
        ItemNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                if (!found) {
                    System.out.println("Items found:");
                    found = true;
                }
                displayItem(current);
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item with name '" + itemName + "' not found.");
        }
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        System.out.printf("Total Inventory Value: $%.2f%n", totalValue);
    }

    public void sortByName(boolean ascending) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, true, ascending);
        System.out.println("Inventory sorted by name " + (ascending ? "ascending" : "descending") + ".");
    }

    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, false, ascending);
        System.out.println("Inventory sorted by price " + (ascending ? "ascending" : "descending") + ".");
    }

    private ItemNode mergeSort(ItemNode node, boolean byName, boolean ascending) {
        if (node == null || node.next == null) {
            return node;
        }
        ItemNode middle = getMiddle(node);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(node, byName, ascending);
        ItemNode right = mergeSort(nextOfMiddle, byName, ascending);

        return merge(left, right, byName, ascending);
    }

    private ItemNode getMiddle(ItemNode node) {
        if (node == null) {
            return node;
        }
        ItemNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ItemNode merge(ItemNode left, ItemNode right, boolean byName, boolean ascending) {
        ItemNode result;
        if (left == null) return right;
        if (right == null) return left;

        boolean condition;
        if (byName) {
            condition = ascending ? left.itemName.compareToIgnoreCase(right.itemName) <= 0
                                  : left.itemName.compareToIgnoreCase(right.itemName) >= 0;
        } else {
            condition = ascending ? left.price <= right.price : left.price >= right.price;
        }

        if (condition) {
            result = left;
            result.next = merge(left.next, right, byName, ascending);
        } else {
            result = right;
            result.next = merge(left, right.next, byName, ascending);
        }
        return result;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- Inventory Items ---");
        ItemNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayItem(current);
            current = current.next;
            position++;
        }
        System.out.println("\nTotal items: " + size);
    }

    private void displayItem(ItemNode node) {
        System.out.println("Item ID: " + node.itemId);
        System.out.println("Item Name: " + node.itemName);
        System.out.println("Quantity: " + node.quantity);
        System.out.printf("Price: $%.2f%n", node.price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagement inventory = new InventoryManagement();

        int choice;
        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Item ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by Item ID");
            System.out.println("7. Search by Item Name");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Display All");
            System.out.println("12. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    if (choice == 1) {
                        inventory.addAtBeginning(name, id, qty, price);
                    } else if (choice == 2) {
                        inventory.addAtEnd(name, id, qty, price);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = scanner.nextInt();
                        inventory.addAtPosition(name, id, qty, price, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeByItemId(removeId);
                    break;
                case 5:
                    System.out.print("Enter Item ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int newQty = scanner.nextInt();
                    inventory.updateQuantity(updateId, newQty);
                    break;
                case 6:
                    System.out.print("Enter Item ID to search: ");
                    int searchId = scanner.nextInt();
                    inventory.searchByItemId(searchId);
                    break;
                case 7:
                    System.out.print("Enter Item Name to search: ");
                    String searchName = scanner.nextLine();
                    inventory.searchByItemName(searchName);
                    break;
                case 8:
                    inventory.calculateTotalValue();
                    break;
                case 9:
                    System.out.print("Sort ascending (true/false): ");
                    boolean nameAsc = scanner.nextBoolean();
                    inventory.sortByName(nameAsc);
                    break;
                case 10:
                    System.out.print("Sort ascending (true/false): ");
                    boolean priceAsc = scanner.nextBoolean();
                    inventory.sortByPrice(priceAsc);
                    break;
                case 11:
                    inventory.displayAll();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 12);

        scanner.close();
    }
}
