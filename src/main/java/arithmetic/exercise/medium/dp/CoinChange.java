package arithmetic.exercise.medium.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * 给你一个整数数组coins，表示不同面额的硬币；以及一个整数amount，表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例：
 * coins = [1, 2, 5], amount = 11  -> result = 3
 * coins = [2], amount = 3 -> result = -1
 * coins = [1], amount = 0 -> result = 0
 * coins = [1], amount = 1 -> result = 1
 * coins = [1], amount = 2 -> result = 2
 */
public class CoinChange {

    private static int solution(int[] coins, int m) {
        if (m == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (m < coins[0]) {
            return 0;
        }
        int count = recursive(coins, m);
        if (count == Integer.MAX_VALUE) {
            return -1;
        }
        return count;
    }

    /**
     * 递归思路：依次拿总金额减去某一个硬币的面值，递归计算剩余总金额所需的硬币数，取最小值。
     * 如果剩余金额最少需要 x 枚硬币，则当前金额需要 x + 1 枚硬币。
     * 递归终止条件：如果剩余金额小于任意一枚硬币的面值，说明匹配不到。如果等于其中一枚硬币，说明可以兑换，return 1。
     */
    private static int recursive(int[] coins, int n) {
        if (n < coins[0]) {
            return Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            if (coin == n) {
                return 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = recursive(coins, n - coin);
            if (count < Integer.MAX_VALUE) {
                min = Math.min(min, count + 1);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 5}, 11) == 3);
        System.out.println(solution(new int[] {2}, 3) == -1);
        System.out.println(solution(new int[] {1}, 0) == 0);
        System.out.println(solution(new int[] {1}, 1) == 1);
        System.out.println(solution(new int[] {1}, 2) == 2);
    }
}
