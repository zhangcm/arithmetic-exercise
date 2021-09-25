package arithmetic.exercise.common;

import java.util.Arrays;

public class ArrayUtils {

    public static void println(char[][] arr) {
        for (char[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void println(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

}
