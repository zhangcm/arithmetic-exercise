package arithmetic.exercise.medium.dp;

/**
 * 最长上升子序列
 *
 * 给你一个整数数组 nums，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除数组中的元素而不改签其余元素的顺序。
 * 例如，[3, 6, 2, 7] 是数组[0, 3, 1, 6, 2, 2, 7]的子序列。
 * [10, 9, 2, 5, 3, 7, 101, 18]  -> [2, 3, 7, 101]
 * [0, 1, 0, 3, 2, 3] -> 4
 * [7, 7, 7, 7, 7] -> 1
 *
 */
public class LengthOfLIS {

    private static int solution(int[] nums) {
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

    public static void main(String[] args) {
        System.out.println(solution(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution(new int[] {0, 1, 0, 3, 2, 3}));
        System.out.println(solution(new int[] {7, 7, 7, 7}));
    }

}
