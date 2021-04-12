package arithmetic.exercise.easy.array;

/**
 *
 */
public class StockTradingV1 {

    private static int solution(int[] nums) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minPrice) {
                minPrice = nums[i];
            } else if (nums[i] - minPrice > profit) {
                profit = nums[i] - minPrice;
            }
        }
        return profit;
    }

    private static int solution2(int[] nums) {
        int maxProfit = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxProfit = Math.max(maxProfit, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return maxProfit;
    }

    private static int solution3(int[] nums) {
        int profit = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int max = 0;
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
            }
            if (max > nums[i]) {
                profit = Math.max(profit, max - nums[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int nums[] = {7, 2, 10, 1, 5, 3, 6, 4};
        System.out.println(solution(nums));
    }

}
