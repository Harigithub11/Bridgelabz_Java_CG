package CoreProgramming.ControlFlows.level3;
import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int p = input.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int c = input.nextInt();
        System.out.print("Enter Maths marks: ");
        int m = input.nextInt();
        double avg = (p + c + m) / 3.0;
        System.out.println("Average Marks: " + avg);
        if (avg >= 80) System.out.println("Grade: A");
        else if (avg >= 70) System.out.println("Grade: B");
        else if (avg >= 60) System.out.println("Grade: C");
        else if (avg >= 50) System.out.println("Grade: D");
        else if (avg >= 40) System.out.println("Grade: E");
        else System.out.println("Grade: R");
        input.close();
    }
}