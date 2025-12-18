package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class MaximumHandshakesMethod {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();
        int result = calculateHandshakes(n);
        System.out.println("Maximum number of handshakes is " + result);
        input.close();
    }
}