package arithmetic.exercise.easy.array;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 */
public class SortArrayDuplicateRemove {


    public static int solution(int[] nums) {
        if (nums.length < 1) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution(nums));
        System.out.println(Arrays.toString(nums));
    }
}
