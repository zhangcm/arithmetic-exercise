package arithmetic.exercise.medium.math;

/**
 * Pow(x, n)
 *
 * 实现pow(x, n)，即计算x的n次幂函数
 *
 * 示例1：
 * x = 2, n = 10 -> 1024
 * x = 2.1, n = 3 -> 9.26100
 * x = 2, n = -2 -> 0.25000
 */
public class MyPow {

    /**
     * TODO
     * 需要处理溢出问题
     */
    private static double solution(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        boolean negative = n < 0;
        int m = Math.abs(n);
        double result = 1;
        double base = x;
        int remind;
        while (m > 1) {
            remind = m % 2;
            if (remind == 1) {
                result = result * base;
            }
            base = base * base;
            m = m / 2;
        }
        result = result * base;
        return negative ? (1 / result) : result;
    }
}
