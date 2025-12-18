package CoreProgramming.Methods.level2;

import java.util.Scanner;

public class UnitConvertor {

    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("1. KM to Miles");
        System.out.println("2. Miles to KM");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");

        int choice = input.nextInt();
        System.out.print("Enter value: ");
        double value = input.nextDouble();

        double result = 0;

        switch (choice) {
            case 1: result = convertKmToMiles(value); break;
            case 2: result = convertMilesToKm(value); break;
            case 3: result = convertMetersToFeet(value); break;
            case 4: result = convertFeetToMeters(value); break;
            default:
                System.out.println("Invalid choice");
                input.close();
                return;
        }

        System.out.println("Converted value is: " + result);
        input.close();
    }
}
