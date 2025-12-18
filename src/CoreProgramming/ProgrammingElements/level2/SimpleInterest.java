package CoreProgramming.ProgrammingElements.level2;

import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter principal: ");
        double principal = input.nextDouble();
        System.out.print("Enter rate of interest: ");
        double rate = input.nextDouble();
        System.out.print("Enter time: ");
        double time = input.nextDouble();
        double si = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is " + si);
        input.close();
    }
}
