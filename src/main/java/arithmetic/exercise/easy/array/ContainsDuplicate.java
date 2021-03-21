package arithmetic.exercise.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中是否存在重复元素
 */
public class ContainsDuplicate {

    private static boolean solution1(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> all = new HashSet<>();
        for (int num : nums) {
            if (!all.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static boolean solution2(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4};
        System.out.println(solution1(nums));
        System.out.println(solution1(nums));
    }
}
