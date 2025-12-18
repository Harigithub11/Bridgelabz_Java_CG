package CoreProgramming.Methods.level2;

import java.util.Scanner;

public class UnitConvertorAdvanced {

    public static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double p) {
        return p * 0.453592;
    }

    public static double convertKilogramsToPounds(double k) {
        return k * 2.20462;
    }

    public static double convertGallonsToLiters(double g) {
        return g * 3.78541;
    }

    public static double convertLitersToGallons(double l) {
        return l * 0.264172;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");

        int choice = input.nextInt();
        System.out.print("Enter value: ");
        double value = input.nextDouble();

        double result = 0;

        switch (choice) {
            case 1: result = convertFahrenheitToCelsius(value); break;
            case 2: result = convertCelsiusToFahrenheit(value); break;
            case 3: result = convertPoundsToKilograms(value); break;
            case 4: result = convertKilogramsToPounds(value); break;
            case 5: result = convertGallonsToLiters(value); break;
            case 6: result = convertLitersToGallons(value); break;
            default:
                System.out.println("Invalid choice");
                input.close();
                return;
        }

        System.out.println("Converted value is: " + result);
        input.close();
    }
}
