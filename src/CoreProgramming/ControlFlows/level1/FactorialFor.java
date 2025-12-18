package CoreProgramming.ControlFlows.level1;
import java.util.Scanner;
public class FactorialFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        if (n >= 0) {
            long fact = 1;
            for (int i = 1; i <= n; i++)
                fact *= i;
            System.out.println("Factorial is " + fact);
        } else {
            System.out.println("Not a natural number");
        }
        input.close();
    }
}