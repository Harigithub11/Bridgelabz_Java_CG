package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radian = Math.toRadians(angle);
        return new double[]{
            Math.sin(radian),
            Math.cos(radian),
            Math.tan(radian)
        };
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();
        double[] result = calculateTrigonometricFunctions(angle);
        System.out.println("Sine: " + result[0] +
                           " Cosine: " + result[1] +
                           " Tangent: " + result[2]);
        input.close();
    }
}