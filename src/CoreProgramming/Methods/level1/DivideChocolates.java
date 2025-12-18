package CoreProgramming.Methods.level1;
import java.util.Scanner;
public class DivideChocolates {
    public static int[] findRemainderAndQuotient(int chocolates, int children) {
        return new int[]{chocolates / children, chocolates % children};
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int chocolates = input.nextInt();
        System.out.print("Enter number of children: ");
        int children = input.nextInt();
        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets " + result[0] + " chocolates and remaining " + result[1]);
        input.close();
    }
}