package CoreProgramming.ControlFlows.level1;
import java.util.Scanner;
public class FactorialWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        long fact = 1;
        int i = 1;
        while (i <= n) {
            fact *= i;
            i++;
        }
        System.out.println("Factorial is " + fact);
        input.close();
    }
}