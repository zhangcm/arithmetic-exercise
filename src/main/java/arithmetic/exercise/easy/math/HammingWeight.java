package arithmetic.exercise.easy.math;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为'1'的个数
 */
public class HammingWeight {

    /**
     * 直接循环检查给定整数n的二进制位的每一位是否为1
     */
    private static int solution(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * n & (n - 1) 结果为把n的二进制位中的最低位的1变为0之后的结果
     * 比如 6 & (6 - 1) = 4
     * 利用这个位运算的性质可以加速检查过程，不断让n与n-1做与运算，直到n变成0
     */
    private static int solution2(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }

    /**
     * Integer.bitCount()
     */
    private static int solution3(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    public static void main(String[] args) {
        System.out.println(solution(64));
        System.out.println(solution2(64));
        System.out.println(solution3(64));
    }

}
