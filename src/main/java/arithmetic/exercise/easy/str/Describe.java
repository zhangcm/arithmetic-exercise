package arithmetic.exercise.easy.str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Describe {

    private static String solution(int n) {
        List<Integer> describeList = describe(n);
        return describeList.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    private static List<Integer> describe(int n) {
        if (n == 1) {
            return Collections.singletonList(1);
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> pre = describe(n - 1);
        int last = pre.get(0);
        int lastStartIndex = 0;
        for (int i = 0; i < pre.size(); i++) {
            if (pre.get(i) != last) {
                result.add(i - lastStartIndex);
                result.add(last);
                last = pre.get(i);
                lastStartIndex = i;
                if (i == pre.size() - 1) {
                    result.add(1);
                    result.add(pre.get(i));
                }
            } else if (i == pre.size() - 1) {
                result.add(i - lastStartIndex + 1);
                result.add(last);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
    }

}
