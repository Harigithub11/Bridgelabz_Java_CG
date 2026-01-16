package objectoriented.programmingfundamentals.level2;

import java.util.Scanner;

public class MovieTicket {
    private static final double BASE_PRICE = 200.0;
    private static final double CHILD_DISCOUNT = 0.50;
    private static final double SENIOR_DISCOUNT = 0.30;
    private static final double MATINEE_DISCOUNT = 0.20;

    private String movieName;
    private String customerName;
    private int customerAge;
    private String showTime;
    private int numberOfTickets;

    public MovieTicket() {
    }

    public MovieTicket(String movieName, String customerName, int customerAge, String showTime, int numberOfTickets) {
        this.movieName = movieName;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.showTime = showTime;
        this.numberOfTickets = numberOfTickets;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    private boolean isMatineeShow() {
        int hour = Integer.parseInt(showTime.split(":")[0]);
        return hour < 17;
    }

    public double calculateTicketPrice() {
        double price = BASE_PRICE;

        if (customerAge < 12) {
            price -= BASE_PRICE * CHILD_DISCOUNT;
        } else if (customerAge >= 60) {
            price -= BASE_PRICE * SENIOR_DISCOUNT;
        }

        if (isMatineeShow()) {
            price -= BASE_PRICE * MATINEE_DISCOUNT;
        }

        return price;
    }

    public double calculateTotalPrice() {
        return calculateTicketPrice() * numberOfTickets;
    }

    public void displayTicketDetails() {
        System.out.println("\n--- Movie Ticket Details ---");
        System.out.println("Movie: " + movieName);
        System.out.println("Customer: " + customerName);
        System.out.println("Age: " + customerAge);
        System.out.println("Show Time: " + showTime);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Price per Ticket: $" + calculateTicketPrice());
        System.out.println("Total Price: $" + calculateTotalPrice());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Movie Name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Age: ");
        int customerAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Show Time (HH:MM format, e.g., 14:30): ");
        String showTime = scanner.nextLine();

        System.out.print("Enter Number of Tickets: ");
        int numberOfTickets = scanner.nextInt();

        MovieTicket ticket = new MovieTicket(movieName, customerName, customerAge, showTime, numberOfTickets);
        ticket.displayTicketDetails();

        System.out.println("\nPricing Info:");
        System.out.println("- Base Price: $" + BASE_PRICE);
        System.out.println("- Children (under 12): 50% discount");
        System.out.println("- Seniors (60+): 30% discount");
        System.out.println("- Matinee shows (before 5 PM): 20% discount");

        scanner.close();
    }
}
