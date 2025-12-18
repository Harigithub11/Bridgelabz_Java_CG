package CoreProgramming.ControlFlows.level3;
import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int original = n, sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum += d * d * d;
            n /= 10;
        }
        System.out.println(sum == original ? "Armstrong Number" : "Not an Armstrong Number");
        input.close();
    }
}