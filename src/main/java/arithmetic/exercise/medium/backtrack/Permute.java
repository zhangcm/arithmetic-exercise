package arithmetic.exercise.medium.backtrack;

import arithmetic.exercise.common.ListUtils;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 全排列
 */
public class Permute {

    // 给定一个不含重复数字的数组nums，返回其所有可能的全排列。你可以按任意顺序返回答案
    // [0, 1] -> [0, 1] [1, 0]
    // [1, 2, 3] -> [1, 2, 3] [1, 3, 2] [2, 1, 3], [2, 3, 1] [3, 1, 2] [3, 2, 1]
    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new LinkedHashSet<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, LinkedHashSet<Integer> set, List<List<Integer>> result) {
        if (set.size() == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }
        for (int num : nums) {
            if (set.add(num)) {
                backtrack(nums, set, result);
                set.remove(num);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> reslut = solution(new int[] {1, 2, 3});
        ListUtils.println(reslut);
        reslut = solution(new int[] {0, 1});
        ListUtils.println(reslut);
    }

}
