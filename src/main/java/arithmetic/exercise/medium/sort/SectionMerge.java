package arithmetic.exercise.medium.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * 以数组intervals表示若干个区间的集合，其中单个区间为intervals[i] = [starti, endi]。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 */
public class SectionMerge {

    private static int[][] solution(int[][] intervals) {
        int length = intervals.length;
        List<List<Integer>> list = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                list.add(Arrays.asList(current[0], current[1]));
            } else {
                int[] next = intervals[i + 1];
                if (current[1] >= next[0]) {
                    current = new int[] {current[0], next[1]};
                } else {
                    list.add(Arrays.asList(current[0], current[1]));
                    current = intervals[i + 1];
                }
            }
        }

        length = list.size();
        int[][] result = new int[length][2];
        for (int i = 0; i < length; i++) {
            result[i] = new int[] {list.get(i).get(0), list.get(i).get(1)};
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution(new int[][] {{1, 4}, {4, 5}})));
    }

}
