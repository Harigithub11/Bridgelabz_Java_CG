package CoreProgramming.Methods.level3;

import java.util.Arrays;

public class UniqueOTPGenerator {

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static void main(String[] args) {
        int[] o = new int[10];
        for (int i = 0; i < 10; i++) o[i] = generateOTP();
        System.out.println(Arrays.toString(o));
    }
}
