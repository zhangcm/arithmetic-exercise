package arithmetic.exercise.easy.dp;

/**
 * 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下，
 * 一夜之内能够偷窃到的最高金额
 */
public class Rob {

    private static int solution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] maxArr = new int[nums.length];
        maxArr[0] = nums[0];
        maxArr[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            maxArr[i] = Math.max(maxArr[i - 2] + nums[i], maxArr[i - 1]);
        }
        return maxArr[nums.length - 1];
    }

    private static int solution2(int[] nums) {
        return recur(nums, nums.length - 1);
    }

    private static int recur(int[] nums, int n) {
        if (n == 0) {
            return nums[0];
        } else if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(recur(nums, n - 2) + nums[n], recur(nums, n - 1));
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(solution(nums));
    }

}
