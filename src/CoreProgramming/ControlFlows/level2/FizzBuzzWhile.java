package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int n = input.nextInt();
        int i = 1;
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
            i++;
        }
        input.close();
    }
}