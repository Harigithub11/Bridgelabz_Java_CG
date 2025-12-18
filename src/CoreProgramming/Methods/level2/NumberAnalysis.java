package CoreProgramming.Methods.level2;
import java.util.Scanner;
public class NumberAnalysis {
    public static boolean isPositive(int n) { return n > 0; }
    public static boolean isEven(int n) { return n % 2 == 0; }
    public static int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number: ");
            numbers[i] = input.nextInt();
            if (isPositive(numbers[i])) {
                System.out.println(isEven(numbers[i]) ? "Even" : "Odd");
            } else {
                System.out.println("Negative or Zero");
            }
        }
        int result = compare(numbers[0], numbers[4]);
        System.out.println(result == 0 ? "Equal" : result > 0 ? "First is Greater" : "Last is Greater");
        input.close();
    }
}