package CoreProgramming.Methods.level2;
import java.util.Scanner;
public class LeapYear {
    public static boolean isLeapYear(int year) {
        return year >= 1582 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = input.nextInt();
        System.out.println(isLeapYear(year) ? "Leap Year" : "Not a Leap Year");
        input.close();
    }
}