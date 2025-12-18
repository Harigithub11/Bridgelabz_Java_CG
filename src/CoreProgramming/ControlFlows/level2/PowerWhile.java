package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class PowerWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = input.nextInt();
        System.out.print("Enter power: ");
        int power = input.nextInt();
        int result = 1, count = 0;
        while (count < power) {
            result *= number;
            count++;
        }
        System.out.println("Result is " + result);
        input.close();
    }
}