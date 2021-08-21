package arithmetic.exercise.medium.backtrack;

import arithmetic.exercise.common.ListUtils;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 子集
 * 给你一个整数数组nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 *
 * 相当于求组合
 * 只需求出以第一个元素为根节点的所有子树
 */
public class Subsets {

    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new LinkedHashSet<>(), result);
        return result;
    }

    /**
     * 不需要重复，记一个起始位置，每次都找这个位置以后的元素
     * 比如[1, 2, 3, 4]
     * 如果第一层初始找1，第二层只需找2，3，4，
     * 如果第二层初始找2，第三层只需找3，4
     * 如果第三层初始找3，第四层只需找4
     */
    private static void backtrack(int[] nums, int startIndex, LinkedHashSet<Integer> set, List<List<Integer>> result) {
        int length = nums.length;
        result.add(new ArrayList<>(set));
        if (startIndex == length) {
            return;
        }
        for (int i = startIndex; i < length; i++) {
            set.add(nums[i]);
            backtrack(nums, i + 1, set, result);
            set.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = solution(new int[] {1});
        ListUtils.println(result);  // [[],[1]]
        result = solution(new int[] {1, 2});
        ListUtils.println(result);  // [[],[1],[1,2],[2]]
        result = solution(new int[] {1, 2, 3});
        ListUtils.println(result);  // [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
        result = solution(new int[] {1, 2, 3, 4});
        ListUtils.println(result);  // [[],[1],[1,2],[1,2,3],[1,2,3,4],[1,2,4],[1,3],[1,3,4],[1,4],[2],[2,3],[2,3,4],[2,4],[3],[3,4],[4]]
    }
}
