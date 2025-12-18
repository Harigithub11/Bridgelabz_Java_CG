package CoreProgramming.ControlFlows.level1;
import java.util.Scanner;
public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();
        if (n > 0) {
            int sumLoop = 0, i = 1;
            while (i <= n) {
                sumLoop += i;
                i++;
            }
            int sumFormula = n * (n + 1) / 2;
            System.out.println("Sum using while loop: " + sumLoop);
            System.out.println("Sum using formula: " + sumFormula);
        } else {
            System.out.println("Not a natural number");
        }
        input.close();
    }
}