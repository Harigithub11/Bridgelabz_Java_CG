package CoreProgramming.Methods.level2;
import java.util.Scanner;
public class FriendsInfo {
    public static int findYoungest(int[] ages) {
        int min = ages[0];
        for (int age : ages) if (age < min) min = age;
        return min;
    }
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int height : heights) if (height > max) max = height;
        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age: ");
            ages[i] = input.nextInt();
            System.out.print("Enter height: ");
            heights[i] = input.nextInt();
        }
        System.out.println("Youngest Age: " + findYoungest(ages));
        System.out.println("Tallest Height: " + findTallest(heights));
        input.close();
    }
}