package CoreProgramming.Arrays.level1;
import java.util.Scanner;
public class FactorsArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int max = 10, index = 0;
        int[] factors = new int[max];
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == max) {
                    max *= 2;
                    int[] temp = new int[max];
                    for (int j = 0; j < index; j++)
                        temp[j] = factors[j];
                    factors = temp;
                }
                factors[index++] = i;
            }
        }
        System.out.println("Factors:");
        for (int i = 0; i < index; i++)
            System.out.print(factors[i] + " ");
        input.close();
    }
}