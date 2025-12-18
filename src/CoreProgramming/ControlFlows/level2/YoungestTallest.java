package CoreProgramming.ControlFlows.level2;
import java.util.Scanner;
public class YoungestTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Amar age and height: ");
        int aAge = input.nextInt(); double aH = input.nextDouble();
        System.out.print("Enter Akbar age and height: ");
        int bAge = input.nextInt(); double bH = input.nextDouble();
        System.out.print("Enter Anthony age and height: ");
        int cAge = input.nextInt(); double cH = input.nextDouble();
        int youngest = Math.min(aAge, Math.min(bAge, cAge));
        double tallest = Math.max(aH, Math.max(bH, cH));
        System.out.println("Youngest age is " + youngest);
        System.out.println("Tallest height is " + tallest);
        input.close();
    }
}