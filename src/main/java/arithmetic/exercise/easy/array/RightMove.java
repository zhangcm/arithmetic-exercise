package arithmetic.exercise.easy.array;

import java.util.Arrays;

public class RightMove {

    private static void solution(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k = k % nums.length;
        int[] temp = new int[k];
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count < k) {
                count++;
                temp[k - count] = nums[i];
            } else {
                nums[i + k] = nums[i];
            }
        }
        if (k >= 0)
            System.arraycopy(temp, 0, nums, 0, k);
    }

    /**
     * 跳跃更新
     * 更新第i个时，同时更新第i + k, i + 2k, i + 3k ...
     * 10 9
     * 0 1 2 3 4 5 6 7 8 9
     *   1 2 3 4 5 6 7 0 9
     *
     *
     * 1 2 3 4 5 6 7 8 9 0
     * 8 1 0 3 2 5 4 7 6 9
     * 8 9 0 1 2 3 4 5 6 7
     */
    private static void solution2(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        int step = k % nums.length - 1;
        for (int i = 0; i < k; i++) {
            int start = i;
            int temp = nums[i + k];
            while (start <= nums.length) {
                if (start + k >= nums.length) {
                    nums[(start + k) % nums.length] = temp;
                } else {
                    temp = nums[start + k];
                    nums[start + k] = nums[start];
                    start += k;
                }
            }
        }
    }

    /**
     * [1, 2, 3, 4, 5, 6, 7]  3 => [5, 6, 7, 1, 2, 3, 4]
     * 翻转
     * [1, 2, 3, 4, 5, 6, 7]
     * [7, 6, 5, 4, 3, 2, 1]
     * [5, 6, 7, 4, 3, 2, 1]
     * [5, 6, 7, 1, 2, 3, 4]
     */
    private static void solution3(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {7, 2, 10, 1, 5, 3, 6, 4};
        solution3(nums, 7);
        System.out.println(Arrays.toString(nums));
    }
}
