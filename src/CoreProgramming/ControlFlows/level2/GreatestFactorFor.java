package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class GreatestFactorFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int greatestFactor = 1;
        for (int i = n - 1; i >= 1; i--) {
            if (n % i == 0) {
                greatestFactor = i;
                break;
            }
        }
        System.out.println("Greatest factor is " + greatestFactor);
        input.close();
    }
}