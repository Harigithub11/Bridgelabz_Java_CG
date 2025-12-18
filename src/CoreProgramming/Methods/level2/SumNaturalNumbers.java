package CoreProgramming.Methods.level2;
import java.util.Scanner;
public class SumNaturalNumbers {
    public static int recursiveSum(int n) {
        if (n == 0) return 0;
        return n + recursiveSum(n - 1);
    }
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();
        if (n <= 0) return;
        System.out.println("Recursive Sum: " + recursiveSum(n));
        System.out.println("Formula Sum: " + formulaSum(n));
        input.close();
    }
}