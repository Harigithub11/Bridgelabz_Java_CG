package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int greatestFactor = 1;
        int i = n - 1;
        while (i >= 1) {
            if (n % i == 0) {
                greatestFactor = i;
                break;
            }
            i--;
        }
        System.out.println("Greatest factor is " + greatestFactor);
        input.close();
    }
}