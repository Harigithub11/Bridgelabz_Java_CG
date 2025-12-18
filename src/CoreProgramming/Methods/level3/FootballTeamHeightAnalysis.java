package CoreProgramming.Methods.level3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class FootballTeamHeightAnalysis {

    public static int[] generateRandomHeights(int size, int minHeight, int maxHeight) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = ThreadLocalRandom.current().nextInt(minHeight, maxHeight + 1);
        }
        return heights;
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int element : arr) sum += element;
        return sum;
    }

    public static double findMeanHeight(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortestHeight(int[] heights) {
        int min = heights[0];
        for (int h : heights) if (h < min) min = h;
        return min;
    }

    public static int findTallestHeight(int[] heights) {
        int max = heights[0];
        for (int h : heights) if (h > max) max = h;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateRandomHeights(11, 150, 250);
        System.out.println(Arrays.toString(heights));
        System.out.println(findSum(heights));
        System.out.println(findMeanHeight(heights));
        System.out.println(findShortestHeight(heights));
        System.out.println(findTallestHeight(heights));
    }
}
