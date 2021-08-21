package arithmetic.exercise.medium.math;

/**
 * x的平方根
 *
 * 实现 int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 *
 * 示例1：
 * 4 -> 2
 * 8 -> 2 (2.82842...)
 */
public class MySqrt {

    /**
     * 二分法
     */
    private static int solution1(int x) {
        int low = 0; int high = x; int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 二分法，
     */
    private static double solution2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x <= 3) {
            return 1;
        }
        if (x >= 2147395600) {
            return 46340;
        }
        int low = 0; int high = Math.min(92680, x);
        while (low < high) {
            int mid = (low + high) / 2;
            int result = mid * mid;
            if (result < x) {
                if ((mid + 1) * (mid + 1) > x) {
                    return mid;
                }
                low = mid;
            } else if (result > x) {
                high = mid;
            } else {
                return mid;
            }
        }
        return low;
    }

    /**
     * 公式法
     * TODO
     */
    private static double solution3(int x) {
        return 0;
    }

    /**
     * 牛顿迭代法
     */
    private static double solution4(int x) {
        return 0;
    }

}
