package CoreProgramming.ControlFlows.level3;
import java.util.Scanner;
public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = input.nextDouble();
        System.out.print("Enter second number: ");
        double b = input.nextDouble();
        System.out.print("Enter operator (+ - * /): ");
        char op = input.next().charAt(0);
        switch (op) {
            case '+': System.out.println(a + b); break;
            case '-': System.out.println(a - b); break;
            case '*': System.out.println(a * b); break;
            case '/': System.out.println(a / b); break;
            default: System.out.println("Invalid Operator");
        }
        input.close();
    }
}