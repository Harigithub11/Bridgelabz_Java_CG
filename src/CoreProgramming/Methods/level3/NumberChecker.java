package CoreProgramming.Methods.level3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {

    public static int[] getDigitsArray(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = Character.getNumericValue(s.charAt(i));
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        if (digits[0] == 0) return false;
        for (int d : digits) if (d == 0) return true;
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int p = digits.length;
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, p);
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = getDigitsArray(n);
        System.out.println(Arrays.toString(d));
        System.out.println(isDuckNumber(d));
        System.out.println(isArmstrong(n, d));
        sc.close();
    }
}
