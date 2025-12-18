package CoreProgramming.Arrays.level2;
import java.util.Scanner;
public class YoungestTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] age = new int[3];
        double[] height = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = input.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            height[i] = input.nextDouble();
        }

        int youngestIndex = 0, tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) youngestIndex = i;
            if (height[i] > height[tallestIndex]) tallestIndex = i;
        }

        System.out.println("Youngest is " + names[youngestIndex]);
        System.out.println("Tallest is " + names[tallestIndex]);
        input.close();
    }
}