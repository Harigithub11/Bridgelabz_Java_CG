package datastructures.linkedlist.doublylinkedlist;

import java.util.Scanner;

public class LibraryManagementSystem {

    private BookNode head;
    private BookNode tail;
    private int size;

    private static class BookNode {
        String bookTitle;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        BookNode next;
        BookNode prev;

        BookNode(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
            this.bookTitle = bookTitle;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    public LibraryManagementSystem() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Book added at beginning.");
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Book added at end.");
    }

    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        if (position == size + 1) {
            addAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
        System.out.println("Book added at position " + position + ".");
    }

    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        current.next = current.prev = null;
        size--;
        System.out.println("Book with ID " + bookId + " removed.");
    }

    public void searchByTitle(String title) {
        BookNode current = head;
        boolean found = false;
        System.out.println("Books matching title '" + title + "':");
        while (current != null) {
            if (current.bookTitle.toLowerCase().contains(title.toLowerCase())) {
                if (!found) found = true;
                displayBook(current);
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found with title containing '" + title + "'.");
        }
    }

    public void searchByAuthor(String author) {
        BookNode current = head;
        boolean found = false;
        System.out.println("Books by author '" + author + "':");
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                if (!found) found = true;
                displayBook(current);
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found by author '" + author + "'.");
        }
    }

    public void updateAvailability(int bookId, boolean isAvailable) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID " + bookId + ".");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\n--- Library Books (Forward Order) ---");
        BookNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayBook(current);
            current = current.next;
            position++;
        }
        System.out.println("\nTotal books: " + size);
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\n--- Library Books (Reverse Order) ---");
        BookNode current = tail;
        int position = size;
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayBook(current);
            current = current.prev;
            position--;
        }
        System.out.println("\nTotal books: " + size);
    }

    public void countBooks() {
        System.out.println("Total books in library: " + size);
        int available = 0, borrowed = 0;
        BookNode current = head;
        while (current != null) {
            if (current.isAvailable) {
                available++;
            } else {
                borrowed++;
            }
            current = current.next;
        }
        System.out.println("Available: " + available);
        System.out.println("Borrowed: " + borrowed);
    }

    private void displayBook(BookNode node) {
        System.out.println("Book ID: " + node.bookId);
        System.out.println("Title: " + node.bookTitle);
        System.out.println("Author: " + node.author);
        System.out.println("Genre: " + node.genre);
        System.out.println("Status: " + (node.isAvailable ? "Available" : "Borrowed"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Book ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Count Books");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    if (choice == 1) {
                        library.addAtBeginning(title, author, genre, bookId, isAvailable);
                    } else if (choice == 2) {
                        library.addAtEnd(title, author, genre, bookId, isAvailable);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = scanner.nextInt();
                        library.addAtPosition(title, author, genre, bookId, isAvailable, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    library.removeByBookId(removeId);
                    break;
                case 5:
                    System.out.print("Enter Title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                case 6:
                    System.out.print("Enter Author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 7:
                    System.out.print("Enter Book ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    boolean newStatus = scanner.nextBoolean();
                    library.updateAvailability(updateId, newStatus);
                    break;
                case 8:
                    library.displayForward();
                    break;
                case 9:
                    library.displayReverse();
                    break;
                case 10:
                    library.countBooks();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 11);

        scanner.close();
    }
}
