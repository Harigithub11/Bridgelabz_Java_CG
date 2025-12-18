package CoreProgramming.Arrays.level2;
import java.util.Scanner;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Physics marks: ");
            physics[i] = input.nextInt();
            System.out.print("Enter Chemistry marks: ");
            chemistry[i] = input.nextInt();
            System.out.print("Enter Maths marks: ");
            maths[i] = input.nextInt();
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Invalid marks");
                i--;
                continue;
            }
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            if (percentage[i] >= 80) grade[i] = 'A';
            else if (percentage[i] >= 70) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 50) grade[i] = 'D';
            else if (percentage[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
            System.out.println("Percentage: " + percentage[i] + " Grade: " + grade[i]);
        }
        input.close();
    }
}