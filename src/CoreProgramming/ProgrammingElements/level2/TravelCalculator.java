package CoreProgramming.ProgrammingElements.level2;

import java.util.Scanner;
public class TravelCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter traveler name: ");
        String name = input.next();
        System.out.print("Enter from city: ");
        String fromCity = input.next();
        System.out.print("Enter via city: ");
        String viaCity = input.next();
        System.out.print("Enter destination city: ");
        String toCity = input.next();
        System.out.print("Enter distance from start to via city: ");
        double d1 = input.nextDouble();
        System.out.print("Enter distance from via to destination: ");
        double d2 = input.nextDouble();
        System.out.print("Enter time taken (hours): ");
        double time = input.nextDouble();
        double totalDistance = d1 + d2;
        double avgSpeed = totalDistance / time;
        System.out.println("Traveler " + name + " traveled from " + fromCity + " to " + toCity + " via " + viaCity + ". Total Distance: " + totalDistance + " miles. Average Speed: " + avgSpeed + " mph.");
        input.close();
    }
}
