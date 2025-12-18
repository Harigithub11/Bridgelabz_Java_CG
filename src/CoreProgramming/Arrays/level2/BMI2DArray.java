package CoreProgramming.Arrays.level2;
import java.util.Scanner;
public class BMI2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[][] personData = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight: ");
            personData[i][0] = input.nextDouble();
            System.out.print("Enter height: ");
            personData[i][1] = input.nextDouble();
            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Invalid input");
                i--;
                continue;
            }
            personData[i][2] = personData[i][0] / Math.pow(personData[i][1] / 100, 2);
            if (personData[i][2] <= 18.4) status[i] = "Underweight";
            else if (personData[i][2] <= 24.9) status[i] = "Normal";
            else if (personData[i][2] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
            System.out.println("BMI: " + personData[i][2] + " Status: " + status[i]);
        }
        input.close();
    }
}