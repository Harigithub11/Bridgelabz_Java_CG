package CoreProgramming.ProgrammingElements.level2;

import java.util.Scanner;
public class TriangularParkRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1: ");
        double s1 = input.nextDouble();
        System.out.print("Enter side 2: ");
        double s2 = input.nextDouble();
        System.out.print("Enter side 3: ");
        double s3 = input.nextDouble();
        double perimeter = s1 + s2 + s3;
        double rounds = 5000 / perimeter;
        System.out.println("The total number of rounds the athlete will run is " + rounds);
        input.close();
    }
}

