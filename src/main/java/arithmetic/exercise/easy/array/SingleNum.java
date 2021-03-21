package arithmetic.exercise.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 */
public class SingleNum {

    /**
     * 异或
     * 1. a ^ 0 = a
     * 2. a ^ a = 0
     * 3. a ^ a ^ b = a ^ b ^ a = b
     */
    private static int solution(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    private static int solution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (i == 1 && nums[i] != nums[i - 1]) {
                return nums[i];
            } else if (i == nums.length - 2 && nums[i] != nums[i + 1]) {
                return nums[i + 1];
            } else if (nums[i] != nums[i -1 ] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * O(n)，需要额外空间
     * 1. 使用set，遍历数组，不存在则放入，存在则删除，留下的就是次数为1的
     * 2. 使用map，记录次数
     * 3. 使用set，遍历数组，放入set。计算set的和，计算数组的和，set和 * 2 - 数组和  = 只出现一次的数字
     */
    private static int solution3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return new ArrayList<>(set).get(0);
    }

    public static void main(String[] args) {
        int nums[] = {4, 1, 2, 1, 2};
    }

}
