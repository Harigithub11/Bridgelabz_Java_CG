package CoreProgramming.Arrays.level2;
import java.util.Scanner;
public class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = input.nextInt();
        int maxDigit = 10, index = 0;
        int[] digits = new int[maxDigit];

        while (number != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < index; i++)
                    temp[i] = digits[i];
                digits = temp;
            }
            digits[index++] = number % 10;
            number /= 10;
        }

        int largest = 0, secondLargest = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
        input.close();
    }
}