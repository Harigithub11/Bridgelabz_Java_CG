package CoreProgramming.ControlFlows.level1;
import java.util.Scanner;
public class SmallestNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = input.nextInt();
        System.out.print("Enter second number: ");
        int b = input.nextInt();
        System.out.print("Enter third number: ");
        int c = input.nextInt();
        System.out.println("Is the first number the smallest? " + (a < b && a < c));
        input.close();
    }
}