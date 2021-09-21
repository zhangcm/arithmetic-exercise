package arithmetic.exercise.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ListUtils {

    private ListUtils() {
        throw new UnsupportedOperationException();
    }

    public static <T> void println(List<List<T>> list) {
        String output = list.stream()
            .map(item ->
                "[" + item.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]")
            .collect(Collectors.joining(", "));
        System.out.println("[" + output + "]");
    }

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
