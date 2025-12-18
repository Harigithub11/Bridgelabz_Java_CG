package CoreProgramming.Arrays.level1;
import java.util.Scanner;
public class Copy2DTo1D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int cols = input.nextInt();
        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        int idx = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter value: ");
                matrix[i][j] = input.nextInt();
                array[idx++] = matrix[i][j];
            }
        System.out.println("1D Array:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        input.close();
    }
}