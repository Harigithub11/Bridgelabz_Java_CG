package CoreProgramming.Arrays.level2;
import java.util.Scanner;
public class BMICalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight in kg: ");
            weight[i] = input.nextDouble();
            System.out.print("Enter height in cm: ");
            height[i] = input.nextDouble();
            if (weight[i] <= 0 || height[i] <= 0) {
                System.out.println("Invalid input");
                i--;
                continue;
            }
        }

        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / Math.pow(height[i] / 100, 2);
            if (bmi[i] <= 18.4) status[i] = "Underweight";
            else if (bmi[i] <= 24.9) status[i] = "Normal";
            else if (bmi[i] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
            System.out.println("BMI: " + bmi[i] + " Status: " + status[i]);
        }
        input.close();
    }
}