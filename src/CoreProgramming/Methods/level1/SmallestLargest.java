package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class SmallestLargest {
    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));
        return new int[]{smallest, largest};
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = input.nextInt();
        System.out.print("Enter second number: ");
        int b = input.nextInt();
        System.out.print("Enter third number: ");
        int c = input.nextInt();
        int[] result = findSmallestAndLargest(a, b, c);
        System.out.println("Smallest: " + result[0] + " Largest: " + result[1]);
        input.close();
    }
}