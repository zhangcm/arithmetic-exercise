package arithmetic.exercise.easy.math;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目
 * 汉明距离广泛应用于多个领域。在编码理论中用于错误检测，在信息论中量化字符串之间的差异
 *
 * `两个整数之间的汉明距离是对应位置上数字不同的位数`
 *
 * 根据以上定义，提出一种XOR(异或)的位运算，当且仅当输入位不同时输出为1
 *
 * 先将两个数异或运算可以将问题转为"位1的个数"，在计算1的个数，即可得出汉明距离
 */
public class HammingDistance {

    private static int solution(int x, int y) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != (y & (1 << i))) {
                ret++;
            }
        }
        return ret;
    }

    private static int solution2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    private static int solution3(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                distance++;
            }
            xor = xor >>> 1;
        }
        return distance;
    }

    private static int solution4(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            xor = xor & (xor - 1);
            distance++;
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 4));  // 2
        System.out.println(solution2(1, 4));  // 2
        System.out.println(solution3(1, 4));  // 2
        System.out.println(solution4(1, 4));  // 2
    }

}
