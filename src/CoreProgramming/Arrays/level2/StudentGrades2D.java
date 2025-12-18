package CoreProgramming.Arrays.level2;
import java.util.Scanner;
public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = input.nextInt();
                if (marks[i][j] < 0) {
                    i--;
                    break;
                }
            }
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
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