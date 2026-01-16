package datastructures.linkedlist.circularlinkedlist;

import java.util.Scanner;

public class OnlineTicketReservation {

    private TicketNode head;
    private int size;

    private static class TicketNode {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    public OnlineTicketReservation() {
        this.head = null;
        this.size = 0;
    }

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            TicketNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
        }
        size++;
        System.out.println("Ticket " + ticketId + " booked successfully.");
    }

    public void removeByTicketId(int ticketId) {
        if (head == null) {
            System.out.println("No tickets in system.");
            return;
        }
        if (head.ticketId == ticketId && size == 1) {
            head = null;
            size = 0;
            System.out.println("Ticket " + ticketId + " removed.");
            return;
        }
        if (head.ticketId == ticketId) {
            TicketNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
            size--;
            System.out.println("Ticket " + ticketId + " removed.");
            return;
        }
        TicketNode temp = head;
        while (temp.next != head && temp.next.ticketId != ticketId) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Ticket " + ticketId + " not found.");
            return;
        }
        temp.next = temp.next.next;
        size--;
        System.out.println("Ticket " + ticketId + " removed.");
    }

    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets in system.");
            return;
        }
        System.out.println("\n--- All Booked Tickets ---");
        TicketNode temp = head;
        int position = 1;
        do {
            System.out.println("\nTicket " + position + ":");
            displayTicket(temp);
            temp = temp.next;
            position++;
        } while (temp != head);
        System.out.println("\nTotal tickets: " + size);
    }

    public void searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets in system.");
            return;
        }
        System.out.println("Tickets for customer '" + customerName + "':");
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                if (!found) found = true;
                displayTicket(temp);
                System.out.println();
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found for customer '" + customerName + "'.");
        }
    }

    public void searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets in system.");
            return;
        }
        System.out.println("Tickets for movie '" + movieName + "':");
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                if (!found) found = true;
                displayTicket(temp);
                System.out.println();
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found for movie '" + movieName + "'.");
        }
    }

    public void countTickets() {
        System.out.println("Total booked tickets: " + size);
    }

    public void searchByTicketId(int ticketId) {
        if (head == null) {
            System.out.println("No tickets in system.");
            return;
        }
        TicketNode temp = head;
        do {
            if (temp.ticketId == ticketId) {
                System.out.println("Ticket found:");
                displayTicket(temp);
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket " + ticketId + " not found.");
    }

    private void displayTicket(TicketNode node) {
        System.out.println("Ticket ID: " + node.ticketId);
        System.out.println("Customer Name: " + node.customerName);
        System.out.println("Movie Name: " + node.movieName);
        System.out.println("Seat Number: " + node.seatNumber);
        System.out.println("Booking Time: " + node.bookingTime);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineTicketReservation system = new OnlineTicketReservation();

        int choice;
        do {
            System.out.println("\n--- Online Ticket Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name");
            System.out.println("5. Search by Movie Name");
            System.out.println("6. Search by Ticket ID");
            System.out.println("7. Count Total Tickets");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String bookingTime = scanner.nextLine();
                    system.addTicket(ticketId, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int cancelId = scanner.nextInt();
                    system.removeByTicketId(cancelId);
                    break;
                case 3:
                    system.displayAllTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name: ");
                    String searchCustomer = scanner.nextLine();
                    system.searchByCustomerName(searchCustomer);
                    break;
                case 5:
                    System.out.print("Enter Movie Name: ");
                    String searchMovie = scanner.nextLine();
                    system.searchByMovieName(searchMovie);
                    break;
                case 6:
                    System.out.print("Enter Ticket ID: ");
                    int searchId = scanner.nextInt();
                    system.searchByTicketId(searchId);
                    break;
                case 7:
                    system.countTickets();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
