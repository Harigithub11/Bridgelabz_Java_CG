package CoreProgramming.ControlFlows.level1;
import java.util.Scanner;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0, num;
        while (true) {
            System.out.print("Enter a number: ");
            num = input.nextDouble();
            if (num == 0)
                break;
            total += num;
        }
        System.out.println("Total sum is " + total);
        input.close();
    }
}