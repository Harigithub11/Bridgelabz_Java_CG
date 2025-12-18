package CoreProgramming.Arrays.level2;
import java.util.Scanner;
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = input.nextInt();
        int[] freq = new int[10];

        while (number != 0) {
            freq[number % 10]++;
            number /= 10;
        }

        for (int i = 0; i < 10; i++)
            if (freq[i] > 0)
                System.out.println("Digit " + i + " occurs " + freq[i] + " times");
        input.close();
    }
}