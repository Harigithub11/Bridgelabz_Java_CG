package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class MultiplesBelowHundredFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number (<100): ");
        int n = input.nextInt();
        if (n > 0 && n < 100) {
            for (int i = 100; i >= 1; i--)
                if (i % n == 0) System.out.println(i);
        }
        input.close();
    }
}