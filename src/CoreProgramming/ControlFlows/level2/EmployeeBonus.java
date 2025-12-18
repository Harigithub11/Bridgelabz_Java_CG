package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service: ");
        int years = input.nextInt();
        double bonus = (years > 5) ? salary * 0.05 : 0;
        System.out.println("Bonus amount is " + bonus);
        input.close();
    }
}