package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class FactorsWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int n = input.nextInt();
        int i = 1;
        while (i < n) {
            if (n % i == 0) System.out.println(i);
            i++;
        }
        input.close();
    }
}