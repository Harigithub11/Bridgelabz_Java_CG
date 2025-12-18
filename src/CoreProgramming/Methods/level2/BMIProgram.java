package CoreProgramming.Methods.level2;
import java.util.Scanner;
public class BMIProgram {
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100;
        return weight / (heightM * heightM);
    }
    public static String getStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 39.9) return "Overweight";
        return "Obese";
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] personData = new double[10][3];
        String[] status = new String[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg): ");
            personData[i][0] = input.nextDouble();
            System.out.print("Enter height (cm): ");
            personData[i][1] = input.nextDouble();
            personData[i][2] = calculateBMI(personData[i][0], personData[i][1]);
            status[i] = getStatus(personData[i][2]);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(personData[i][0] + " " +
                               personData[i][1] + " " +
                               personData[i][2] + " " +
                               status[i]);
        }
        input.close();
    }
}