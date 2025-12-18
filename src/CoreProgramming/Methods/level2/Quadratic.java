package CoreProgramming.Methods.level2;
import java.util.Scanner;
public class Quadratic {
    public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) return new double[0];
        if (delta == 0) return new double[]{ -b / (2 * a) };
        double r1 = (-b + Math.sqrt(delta)) / (2 * a);
        double r2 = (-b - Math.sqrt(delta)) / (2 * a);
        return new double[]{ r1, r2 };
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();
        double[] roots = findRoots(a, b, c);
        for (double root : roots) System.out.println("Root: " + root);
        input.close();
    }
}