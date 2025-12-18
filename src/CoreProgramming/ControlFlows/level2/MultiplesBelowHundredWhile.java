package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class MultiplesBelowHundredWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number (<100): ");
        int n = input.nextInt();
        int i = 100;
        while (i >= 1) {
            if (i % n == 0) System.out.println(i);
            i--;
        }
        input.close();
    }
}