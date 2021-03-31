package arithmetic.exercise.easy.array;

/**
 * 买卖股票的最佳时机II
 *
 * 给定一个数组，它的第i个元素是一支给定股票第i天的价格
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 *
 * 输入：[7, 1, 5, 3, 6, 4]
 * 输出: 7
 */
public class MaxProfit {

    private static int solution(int[] nums) {
        int maxProfit = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (nums[i - 1] > min) {
                    maxProfit += nums[i - 1] - min;
                }
                min = nums[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 2, 6, 4};
        System.out.println(solution(nums));
    }
}
