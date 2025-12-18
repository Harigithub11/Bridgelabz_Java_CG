package CoreProgramming.ProgrammingElements.level1;

import java.util.Scanner;
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = input.nextDouble();
        System.out.print("Enter height: ");
        double height = input.nextDouble();
        double areaInches = 0.5 * base * height;
        double areaCm = areaInches * 2.54 * 2.54;
        System.out.println("The area of the triangle in square inches is " + areaInches + " and in square centimeters is " + areaCm);
        input.close();
    }
}
