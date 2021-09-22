package arithmetic.exercise.dp.medium;

/**
 * 300. Longest Increasing Subsequence [medium]
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
 * the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]
 *
 * nums = [10,9,2,5,3,7,101,18] -> [2,3,7,101]
 */
public class LongestIncreasingSubsequence {

    private static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        int ans = 0;
        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, result[j]);
                }
            }
            result[i] = max + 1;
            ans = Math.max(ans, result[i]);
        }
        return ans;
    }

    /**
     * TODO 扑克牌解法
     */
    private static int lengthOfLIS1(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[] {7, 7, 7, 7}));
    }
}
