package CoreProgramming.Methods.level2;
public class RandomAnalysis {
    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = (int)(Math.random() * 9000) + 1000;
        return arr;
    }
    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return new double[]{ (double) sum / numbers.length, min, max };
    }
    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);
        double[] result = findAverageMinMax(numbers);
        for (int n : numbers) System.out.print(n + " ");
        System.out.println("\nAverage: " + result[0]);
        System.out.println("Minimum: " + result[1]);
        System.out.println("Maximum: " + result[2]);
    }
}