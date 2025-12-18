package CoreProgramming.Methods.level3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerPalindrome {

    public static int[] getDigitsArray(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = Character.getNumericValue(s.charAt(i));
        return digits;
    }

    public static boolean isPalindrome(int[] d) {
        for (int i = 0; i < d.length / 2; i++)
            if (d[i] != d[d.length - 1 - i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = getDigitsArray(n);
        System.out.println(Arrays.toString(d));
        System.out.println(isPalindrome(d));
        sc.close();
    }
}
