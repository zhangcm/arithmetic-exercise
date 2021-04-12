package arithmetic.exercise.easy.array;

import java.util.Arrays;

/**
 * 缺失数字
 *
 * 给定一个包含[0, n]中n个数的数组nums，找出[0, n]这个范围内没有出现在数组中的那个数
 */
public class MissingNumber {

    private static int solution2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] - 1) {
                return nums[i] + 1;
            }
        }
        return nums.length;
    }

    /**
     * 不缺数字时的总和 - 已有数字的总和 = 缺失数字
     */
    private static int solution(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // sum += (i + 1);
            // sum -= nums[i];
            sum += i + 1 - nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(solution(nums));   // 2
        nums = new int[] {0, 1};
        System.out.println(solution(nums));   // 2
        nums = new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(solution(nums));   // 8
        nums = new int[] {0};
        System.out.println(solution(nums));   // 1
    }

}
