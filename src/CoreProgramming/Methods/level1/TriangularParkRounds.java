package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class TriangularParkRounds {
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1: ");
        double s1 = input.nextDouble();
        System.out.print("Enter side 2: ");
        double s2 = input.nextDouble();
        System.out.print("Enter side 3: ");
        double s3 = input.nextDouble();
        double rounds = calculateRounds(s1, s2, s3);
        System.out.println("Number of rounds required is " + rounds);
        input.close();
    }
}