package arithmetic.exercise.medium.sort;

import arithmetic.exercise.common.SortHelper;
import java.util.Arrays;

public class SortColors {

    private static void solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int length = nums.length;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                SortHelper.swap(nums, i, startIndex);
                startIndex++;
                if (nums[i] == 2) {
                    SortHelper.swap(nums, i, endIndex);
                    endIndex--;
                }
            } else if (nums[i] == 2) {
                SortHelper.swap(nums, i, endIndex);
                endIndex--;
                if (nums[i] == 0) {
                    SortHelper.swap(nums, i, startIndex);
                    startIndex++;
                }
            }
            if (i >= endIndex) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 0, 0, 0};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
