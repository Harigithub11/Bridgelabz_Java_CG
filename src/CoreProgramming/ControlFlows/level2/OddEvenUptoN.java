package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class OddEvenUptoN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();
        if (n > 0) {
            for (int i = 1; i <= n; i++)
                System.out.println(i + (i % 2 == 0 ? " is Even" : " is Odd"));
        } else {
            System.out.println("Not a natural number");
        }
        input.close();
    }
}