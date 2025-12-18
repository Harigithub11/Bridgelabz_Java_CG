package CoreProgramming.ProgrammingElements.level2;

import java.util.Scanner;
public class IntOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value of a: ");
        int a = input.nextInt();
        System.out.print("Enter value of b: ");
        int b = input.nextInt();
        System.out.print("Enter value of c: ");
        int c = input.nextInt();
        int r1 = a + b * c;
        int r2 = a * b + c;
        int r3 = c + a / b;
        int r4 = a % b + c;
        System.out.println("The results of Int Operations are " + r1 + ", " + r2 + ", " + r3 + ", and " + r4);
        input.close();
    }
}
