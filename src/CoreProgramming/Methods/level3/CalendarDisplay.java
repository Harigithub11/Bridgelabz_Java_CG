package CoreProgramming.Methods.level3;

import java.util.Scanner;

public class CalendarDisplay {

    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean leap(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(m + " " + y);
        sc.close();
    }
}
