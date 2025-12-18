package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class MaximumHandshakesDirect {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();
        int handshakes = (n * (n - 1)) / 2;
        System.out.println("Maximum number of handshakes is " + handshakes);
        input.close();
    }
}