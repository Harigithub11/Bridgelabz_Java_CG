package CoreProgramming.ControlFlows.level3;
import java.util.Scanner;
public class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        System.out.println("Number of digits: " + count);
        input.close();
    }
}