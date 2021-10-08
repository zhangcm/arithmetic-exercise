package arithmetic.exercise.todo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 354. Russian Doll Envelopes [hard]
 *
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width
 * and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater
 * than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * envelopes = [[5,4],[6,4],[6,7],[2,3]] => 3 ([2,3] => [5,4] => [6,7])
 *
 */
public class RussianDollEnvelopes {

    /**
     * TODO run
     */
    /**
     * 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。之后把所有的 h 作为一个数组，
     * 在这个数组上计算 LIS 的长度就是答案。
     */
    private static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]) {
                    return -1;
                } else if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        });
        int length = envelopes.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = envelopes[i][1];
        }
        return lengthOfLIS1(result);
    }

    private static int lengthOfLIS1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int index = -1;
            for (int i = 0, size = list.size(); i < size; i++) {
                if (num <= list.get(i)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                list.add(num);
            } else {
                list.set(index, num);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));  // 3
        System.out.println(maxEnvelopes(new int[][] {{1, 1}, {1, 1}, {1, 1}}));  // 1
    }

}
