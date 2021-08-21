package arithmetic.exercise.medium.other;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 多数元素
 * 给定一个大小为n的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于[n / 2]的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例：
 * [3, 2, 3] -> 3
 * [2, 2, 1, 1, 1, 2, 2] -> 2
 *
 * 进阶：
 * 尝试设计时间复杂度为O(n)、空间复杂度为O(1)的算法
 */
public class MajorityElement {

    private static int solution2(int[] nums) {
        int limit = nums.length / 2;
        Map<Integer, Long>
            result = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return result.keySet().stream().filter(key -> result.get(key) > limit).findFirst().get();
    }

    private static int solution3(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int half = nums.length / 2;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 1;
            } else if (++count > half) {
                return nums[i];
            }
        }
        return nums[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution3(new int[] {3, 2, 3}));  // 3
        System.out.println(solution3(new int[] {2, 2, 1, 1, 1, 2, 2}));  // 2
    }
}
