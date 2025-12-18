package CoreProgramming.Methods.level3;

import java.util.Scanner;

public class NumberCheckerSpecial {

    public static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isBuzz(n));
        sc.close();
    }
}
