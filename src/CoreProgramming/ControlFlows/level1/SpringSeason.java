package CoreProgramming.ControlFlows.level1;
import java.util.Scanner;
public class SpringSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = input.nextInt();
        System.out.print("Enter day: ");
        int day = input.nextInt();
        boolean isSpring = (month == 3 && day >= 20) || (month > 3 && month < 6) || (month == 6 && day <= 20);
        System.out.println(isSpring ? "Its a Spring Season" : "Not a Spring Season");
        input.close();
    }
}