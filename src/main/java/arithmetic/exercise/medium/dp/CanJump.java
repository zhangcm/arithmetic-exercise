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
        int length = nums.length;
        int far = 0;
        for (int i = 0; i < length - 1; i++) {
            int cur = i + nums[i];
            far = Math.max(cur, far);
            if (far <= i) {
                return false;
            }
        }
        return far >= length - 1;
    }

    public static void main(String[] args) {
        // System.out.println(canJump1(new int[] {2, 3, 1, 1, 4}));    // true
        System.out.println(canJump1(new int[] {3, 2, 2, 0, 4}));    // false
    }

}
