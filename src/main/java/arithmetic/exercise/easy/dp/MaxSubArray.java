package arithmetic.exercise.easy.dp;

/**
 * 最大子序和
 *
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和
 * 输入：nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * 输出：6
 */
public class MaxSubArray {

    private static int solution(int[] nums) {
        int[] sumArr = new int[nums.length];
        sumArr[nums.length - 1] = nums[nums.length - 1];
        // 先预存从当前元素开始，往后连续元素的最大和
        for (int i = nums.length - 2; i >= 0; i--) {
            sumArr[i] = Math.max(nums[i], nums[i] + sumArr[i + 1]);
        }
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                if (sumArr[i] > 0) {
                    sum += sumArr[i];
                }
                maxSum = Math.max(maxSum, sum);
                sum = 0;
            }
        }
        return Math.max(maxSum, sum);
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, -5, 10, 6, -6, -7};
        System.out.println(solution(nums));
    }

}
