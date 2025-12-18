package CoreProgramming.Arrays.level1;
import java.util.Scanner;
public class MultiplicationTableArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int[] table = new int[10];
        for (int i = 1; i <= 10; i++)
            table[i - 1] = number * i;
        for (int i = 1; i <= 10; i++)
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        input.close();
    }
}