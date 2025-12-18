package CoreProgramming.ControlFlows.level3;
import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int sum = 0, temp = n;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        System.out.println(n % sum == 0 ? "Harshad Number" : "Not a Harshad Number");
        input.close();
    }
}