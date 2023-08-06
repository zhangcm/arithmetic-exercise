package arithmetic.exercise.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 773. Sliding Puzzle
 */
public class SlidingPuzzle {

    /**
     * TODO run
     */
    /**
     * 二维数组转一维，然后BFS。
     * 难点在二维数组到一维数组的映射
     * [
     *    [0, 1, 2]   =>  [0, 1, 2, 3, 4, 5]
     *    [3, 4, 5]
     * ]
     * 写出数组索引的转化关系， 0号位置的相邻点是1号和3位置，可以直接交换，依此类推
     */
    private static int slidingPuzzle(int[][] board) {
        int[][] neighbor = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };
        char[] start = new char[board.length * board[0].length];
        int index = 0;
        for (int[] rol : board) {
            for (int ele : rol) {
                start[index++] = (char) (ele + '0');
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(new String(start));
        Set<String> visited = new HashSet<>();
        String cur;
        String target = "123450";
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                char[] ch = cur.toCharArray();
                index = -1;
                for (int j = 0, length = ch.length; j < length; j++) {
                    if (ch[j] == '0') {
                        index = j;
                        break;
                    }
                }
                for (int k : neighbor[index]) {
                    ch[index] = ch[k];
                    ch[k] = '0';
                    String s = new String(ch);
                    if (Objects.equals(s, target)) {
                        return step;
                    }
                    if (visited.add(s)) {
                        queue.offer(s);
                    }
                    ch[k] = ch[index];
                    ch[index] = '0';
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][] {{1, 2, 3}, {4, 0, 5}}));  // 1
        System.out.println(slidingPuzzle(new int[][] {{1, 2, 3}, {5, 4, 0}}));  // -1
        System.out.println(slidingPuzzle(new int[][] {{4, 1, 2}, {5, 0, 3}}));  // 5
        System.out.println(slidingPuzzle(new int[][] {{3, 2, 4}, {1, 5, 0}}));  // 14
    }

}
