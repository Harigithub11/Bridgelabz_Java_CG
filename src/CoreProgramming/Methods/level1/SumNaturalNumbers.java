package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class SumNaturalNumbers {
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i;
        return sum;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();
        int sum = calculateSum(n);
        System.out.println("Sum of natural numbers is " + sum);
        input.close();
    }
}