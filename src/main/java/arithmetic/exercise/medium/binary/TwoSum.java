package arithmetic.exercise.medium.binary;

/**
 * 两数之和，不能使用'+'和'-'
 */
public class TwoSum {

    /**
     * 1. 使用异或运算获取无进位结果
     * 2. 使用与运算和移位运算获取获取进位结果
     * 3. 循环此过程直到与运算结果为0（无进位）
     *
     * 0 + 0 = 0
     * 0 + 1 = 1
     * 1 + 0 = 1
     * 1 + 1 = 10
     *
     *    0101          0101
     *  ^ 0100        & 0100
     *  -------      --------
     *    0001          0100 << 1000
     *
     *    0001 + 1000 = 1001
     */
    private static int solution(int a, int b) {
        return getSum(a, b);
    }

    private static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 5));                  // 9
        System.out.println(solution(123456789, 9876543));    // 133333332
    }

}
