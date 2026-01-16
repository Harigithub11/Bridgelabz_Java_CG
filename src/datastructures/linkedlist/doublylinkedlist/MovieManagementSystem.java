package datastructures.linkedlist.doublylinkedlist;

import java.util.Scanner;

public class MovieManagementSystem {

    private MovieNode head;
    private MovieNode tail;
    private int size;

    private static class MovieNode {
        String movieTitle;
        String director;
        int yearOfRelease;
        double rating;
        MovieNode next;
        MovieNode prev;

        MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
            this.movieTitle = movieTitle;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Movie added at beginning.");
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Movie added at end.");
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        if (position == size + 1) {
            addAtEnd(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
        System.out.println("Movie added at position " + position + ".");
    }

    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        MovieNode current = head;
        while (current != null && !current.movieTitle.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie '" + title + "' not found.");
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
        System.out.println("Movie '" + title + "' removed.");
    }

    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        System.out.println("Movies by director '" + director + "':");
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                if (!found) found = true;
                displayMovie(current);
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by this director.");
        }
    }

    public void searchByRating(double minRating) {
        MovieNode current = head;
        boolean found = false;
        System.out.println("Movies with rating >= " + minRating + ":");
        while (current != null) {
            if (current.rating >= minRating) {
                if (!found) found = true;
                displayMovie(current);
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating >= " + minRating + ".");
        }
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\n--- Movies (Forward Order) ---");
        MovieNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayMovie(current);
            current = current.next;
            position++;
        }
        System.out.println("\nTotal movies: " + size);
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\n--- Movies (Reverse Order) ---");
        MovieNode current = tail;
        int position = size;
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayMovie(current);
            current = current.prev;
            position--;
        }
        System.out.println("\nTotal movies: " + size);
    }

    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.movieTitle.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for '" + title + "'.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    private void displayMovie(MovieNode node) {
        System.out.println("Title: " + node.movieTitle);
        System.out.println("Director: " + node.director);
        System.out.println("Year: " + node.yearOfRelease);
        System.out.println("Rating: " + node.rating);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManagementSystem movieList = new MovieManagementSystem();

        int choice;
        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Update Rating");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Movie Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = scanner.nextDouble();
                    if (choice == 1) {
                        movieList.addAtBeginning(title, director, year, rating);
                    } else if (choice == 2) {
                        movieList.addAtEnd(title, director, year, rating);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = scanner.nextInt();
                        movieList.addAtPosition(title, director, year, rating, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Movie Title to remove: ");
                    String removeTitle = scanner.nextLine();
                    movieList.removeByTitle(removeTitle);
                    break;
                case 5:
                    System.out.print("Enter Director name: ");
                    String searchDir = scanner.nextLine();
                    movieList.searchByDirector(searchDir);
                    break;
                case 6:
                    System.out.print("Enter minimum rating: ");
                    double minRating = scanner.nextDouble();
                    movieList.searchByRating(minRating);
                    break;
                case 7:
                    movieList.displayForward();
                    break;
                case 8:
                    movieList.displayReverse();
                    break;
                case 9:
                    System.out.print("Enter Movie Title: ");
                    String updateTitle = scanner.nextLine();
                    System.out.print("Enter new Rating: ");
                    double newRating = scanner.nextDouble();
                    movieList.updateRating(updateTitle, newRating);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
