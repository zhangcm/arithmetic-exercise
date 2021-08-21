package arithmetic.exercise.medium.dp;

/**
 * 跳跃游戏
 * 给定一个非负整数数组nums，你最初位于数组的第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能到达最后一个下标
 * 例：
 * [2 3 1 1 4] -> true
 * [3 2 1 0 4] -> false
  */


public class CanJump {

    /**
     * 动态规划
     */
    private static boolean solution(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!canJump[i]) {
                return false;
            }
            int step = nums[i];
            if (step == 0) {
                continue;
            }
            for (int j = 1; j <= step; j++) {
                if (i + j < nums.length) {
                    canJump[i + j] = true;
                }
            }
        }
        return canJump[nums.length - 1];
    }

    /**
     * 贪心
     */
    private static boolean canJump1(int[] nums) {
        int far = 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = i + nums[i] + 1;
            if (cur <= far) {
                return false;
            }
            far = cur;
            if (far >= nums.length) {
                return true;
            }
        }
        return far >= nums.length;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 3, 1, 1, 4}));    // true
        System.out.println(solution(new int[] {3, 2, 1, 0, 4}));    // false
    }

}
