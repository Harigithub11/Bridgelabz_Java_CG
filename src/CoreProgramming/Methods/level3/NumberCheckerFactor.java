package CoreProgramming.Methods.level3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerFactor {

    public static int[] findFactors(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) c++;
        int[] f = new int[c];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) f[idx++] = i;
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Arrays.toString(findFactors(n)));
        sc.close();
    }
}
