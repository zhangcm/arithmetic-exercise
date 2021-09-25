package arithmetic.exercise.common;

import java.util.List;
import java.util.stream.Collectors;

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

}
