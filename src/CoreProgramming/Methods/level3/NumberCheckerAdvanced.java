package CoreProgramming.Methods.level3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerAdvanced {

    public static int[] getDigitsArray(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = Character.getNumericValue(s.charAt(i));
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static boolean isHarshad(int n, int[] digits) {
        return n % sumOfDigits(digits) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = getDigitsArray(n);
        System.out.println(Arrays.toString(d));
        System.out.println(sumOfDigits(d));
        System.out.println(isHarshad(n, d));
        sc.close();
    }
}
