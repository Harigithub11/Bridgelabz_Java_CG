package CoreProgramming.Arrays.level1;
import java.util.Scanner;
public class StoreNumbersAndSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        int index = 0;
        while (true) {
            System.out.print("Enter a number: ");
            double n = input.nextDouble();
            if (n <= 0 || index == 10)
                break;
            numbers[index++] = n;
        }
        double total = 0;
        for (int i = 0; i < index; i++)
            total += numbers[i];
        System.out.println("Sum is " + total);
        input.close();
    }
}