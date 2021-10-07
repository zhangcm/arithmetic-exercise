package arithmetic.exercise.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock [medium]
 */
public class OpenTheLock {

    /**
     * TODO run
     */
    /**
     * BFS通用框架
     * 1. 通过visited避免重复访问
     * 2. 在offer的时候就判断可以提高效率
     */
    private static int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(deadends.length);
        for (int i = 0, length = deadends.length; i < length; i++) {
            deadendSet.add(deadends[i]);
        }
        if (deadendSet.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        List<Integer> list = Arrays.asList(-1, 1);
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int step = 0;
        String cur;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                // if (Objects.equals(cur, target)) {
                //     return step;
                // }
                for (int j = 0; j < 4; j++) {
                    for (int k : list) {
                        String rotateStr = rotate(cur, j, k);
                        if (Objects.equals(rotateStr, target)) {
                            return step;
                        }
                        if (!deadendSet.contains(rotateStr) && visited.add(rotateStr)) {
                            queue.offer(rotateStr);
                        }
                    }
                }
            }
            // step++;
        }
        return -1;
    }

    private static String rotate(String cur, int j, int k) {
        char[] charArr = cur.toCharArray();
        char ch = charArr[j];
        if (ch == '0' && k == -1) {
            charArr[j] = '9';
        } else if (ch == '9' && k == 1) {
            charArr[j] = '0';
        } else {
            charArr[j] = (char) (ch + k);
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[] {"0201", "0101", "0102", "1212", "2002"}, "0202"));  // 6
        System.out.println(openLock(new String[] {"8888"}, "0009"));  // 1
        System.out.println(openLock(new String[] {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888")); // -1
        System.out.println(openLock(new String[] {"0000"}, "8888")); // -1
    }
}
