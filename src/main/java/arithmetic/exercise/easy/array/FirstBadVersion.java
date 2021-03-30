package arithmetic.exercise.easy.array;

import java.util.HashMap;
import java.util.Map;

public class FirstBadVersion {

    private static Map<Integer, Boolean> badVersionMap = new HashMap<>();

    private static int solution(int n) {
        return recur(1, n);
    }

    private static int recur(int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (isBadVersion(mid)) {
            if (!isBadVersion(mid - 1)) {
                return mid;
            } else {
                return recur(start, mid - 1);
            }
        } else {
            return recur(mid + 1, end);
        }
    }

    private static boolean isBadVersion(int n) {
        return badVersionMap.get(n);
    }

    public static void main(String[] args) {
        badVersionMap.put(1, false);
        badVersionMap.put(2, false);
        badVersionMap.put(3, false);
        badVersionMap.put(4, false);
        badVersionMap.put(5, true);

        System.out.println(solution(5));
    }

}
