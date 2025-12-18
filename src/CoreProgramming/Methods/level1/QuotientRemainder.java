package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = input.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = input.nextInt();
        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.println("Quotient: " + result[0] + " Remainder: " + result[1]);
        input.close();
    }
}