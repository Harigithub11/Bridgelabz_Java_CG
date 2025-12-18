package CoreProgramming.Arrays.level1;
import java.util.Scanner;
public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.out.println("Invalid input");
            return;
        }
        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];
        int o = 0, e = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0)
                even[e++] = i;
            else
                odd[o++] = i;
        }
        System.out.println("Odd Numbers:");
        for (int i = 0; i < o; i++)
            System.out.print(odd[i] + " ");
        System.out.println("\nEven Numbers:");
        for (int i = 0; i < e; i++)
            System.out.print(even[i] + " ");
        input.close();
    }
}