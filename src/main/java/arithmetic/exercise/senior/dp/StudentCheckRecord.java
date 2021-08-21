package arithmetic.exercise.senior.dp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 552. 学生出勤记录 II
 */
public class StudentCheckRecord {

    /**
     * 动态规划 状态转移
     */
    private static int solution1(int n) {
        if (n == 1) {
            return 3;
        }
        if (n == 2) {
            return 8;
        }

        long[][] result = new long[n][12];
        int mod = 1000000007;

        result[2][0] = 2;     // 0A RL
        result[2][1] = 2;     // 0A RR
        result[2][2] = 1;     // 0A LL
        result[2][3] = 2;     // 0A LR

        result[2][4] = 2;     // 1A AL
        result[2][5] = 2;     // 1A AR
        result[2][6] = 2;     // 1A LA
        result[2][7] = 1;     // 1A LL
        result[2][8] = 1;     // 1A LR
        result[2][9] = 2;     // 1A RA
        result[2][10] = 1;    // 1A RL
        result[2][11] = 1;    // 1A RR


        for (int i = 3; i < n; i++) {
            result[i][0] = (result[i - 1][1] + result[i - 1][3]) % mod;
            result[i][1] = (result[i - 1][1] + result[i - 1][3]) % mod;
            result[i][2] = result[i - 1][0] % mod;
            result[i][3] = (result[i - 1][0] + result[i - 1][2]) % mod;
            result[i][4] = (result[i - 1][6] + result[i - 1][9]) % mod;
            result[i][5] = (result[i - 1][6] + result[i - 1][9]) % mod;
            result[i][6] = (result[i - 1][0] + result[i - 1][2]) % mod;
            result[i][7] = (result[i - 1][4] + result[i - 1][10]) % mod;
            result[i][8] = (result[i - 1][4] + result[i - 1][7] + result[i - 1][10] % mod) % mod;
            result[i][9] = (result[i - 1][1] + result[i - 1][3]) % mod;
            result[i][10] = (result[i - 1][5] + result[i - 1][8] + result[i - 1][11]) % mod;
            result[i][11] = (result[i - 1][5] + result[i - 1][8] + result[i - 1][11]) % mod;
        }
        long count = 0;
        for (int i = 0; i < 12; i++) {
            count = ((count + result[n - 1][i]) % mod);
        }
        return (int) count;
    }

    /**
     * 官方动态规划
     */
    private static int solution2(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3]; // 长度，A 的数量，结尾连续 L 的数量
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 以 P 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // 以 L 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }

    /**
     * 回溯，超过20就很慢了
     */
    private static int checkStudentRecord(int n) {
        char[] arr = new char[] {'A', 'L', 'P'};
        StringBuilder strb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        backtrack(arr, strb, 0, n, 0, 0, count);
        return count.get();
    }

    private static void backtrack(char[] arr, StringBuilder strb, int index, int total, int acount, int lcount, AtomicInteger count) {
        if (acount >= 2 || lcount >= 3) {
            return;
        }
        if (index == total) {
            int value = count.get();
            if (value == 1000000007) {
                count.set(1);
            } else {
                count.incrementAndGet();
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            strb.append(arr[i]);
            backtrack(arr, strb, index + 1, total, arr[i] == 'A' ? (acount + 1) : acount, arr[i] == 'L' ? (lcount + 1) : 0, count);
            strb.deleteCharAt(strb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution1(1));      // 3
        System.out.println(solution1(2));      // 8
        System.out.println(solution1(10101));  // 183236316
    }
}
