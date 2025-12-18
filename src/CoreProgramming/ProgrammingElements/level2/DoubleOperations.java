package CoreProgramming.ProgrammingElements.level2;

import java.util.Scanner;
public class DoubleOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value of a: ");
        double a = input.nextDouble();
        System.out.print("Enter value of b: ");
        double b = input.nextDouble();
        System.out.print("Enter value of c: ");
        double c = input.nextDouble();
        double r1 = a + b * c;
        double r2 = a * b + c;
        double r3 = c + a / b;
        double r4 = a % b + c;
        System.out.println("The results of Double Operations are " + r1 + ", " + r2 + ", " + r3 + ", and " + r4);
        input.close();
    }
}
