package arithmetic.exercise.easy.math;

/**
 * 颠倒二进制位
 *
 * 颠倒给定的32位无符号整数的二进制位
 */
public class ReverseBinary {

    private static int solution(int n) {
        for (int i = 0; i < 16; i++) {
            int low = n & (1 << i);
            int high = n & (1 << (31 - i));
            if (low == 0) {
                n = n & (0xffffffff - (1 << (31 - i)));
            } else {
                n = n | (1 << (31 - i));
            }
            if (high == 0) {
                n = n & (0xffffffff - (1 << i));
            } else {
                n = n | (1 << i);
            }
        }
        return n;
    }

    private static int solution2(int n) {
        // 有可能不足32位前面补0
        String s = Integer.toBinaryString(n);
        char[] arr = new char[32];
        int length = s.length();
        for (int i = 0; i < 32; i++) {
            if (i < 32 - length) {
                arr[i] = '0';
            } else {
                arr[i] = s.charAt(i + length - 32);
            }
        }
        for (int i = 0; i < 16; i++) {
            char temp = arr[i];
            arr[i] = arr[31 - i];
            arr[31 - i] = temp;
        }
        return Integer.valueOf(new String(arr), 2);
    }

    /**
     * 逐位颠倒
     */
    private static int solution3(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    private static int solution4(int n) {
        return Integer.reverse(n);
    }

    /**
     * 位运算分治
     * 将其分成左右两部分，对每部分递归执行翻转操作，然后将左半部分拼在右半部分的后面，即完成了翻转
     * b1 b2
     * b1 b2 & 1 0 = b1 0 >> 0 b1
     * b1 b2 & 0 1 = 0 b2 << b2 0
     * 0 b1 | b2 0 = b2 b1
     * 完成颠倒
     */
    private static int solution5(int n) {
        int M1 = 0x55555555;    // 01010101010101010101010101010101
        int M2 = 0x33333333;    // 00110011001100110011001100110011
        int M4 = 0x0f0f0f0f;    // 00001111000011110000111100001111
        int M8 = 0x00ff00ff;    // 00000000111111110000000011111111

        // n >>> 1 高位移到低位  & M1 保留了低位的数字
        // n & M1 保留了原来的低位  << 1 低位移到高位
        // 或运算完成交换
        n = n >>> 1 & M1 | (n & M1) << 1;    // 相邻1位相互交换
        n = n >>> 2 & M2 | (n & M2) << 2;    // 相邻2位相互交换
        n = n >>> 4 & M4 | (n & M4) << 4;    // 相邻4位相互交换
        n = n >>> 8 & M8 | (n & M8) << 8;    // 相邻8位相互交换
        return n >>> 16 | n << 16;           // 相邻16位相互交换
    }

    private static int solution6(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev = (rev << 1) | (n & 1);
            n >>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(solution(43261596));   // 964176192
        System.out.println(solution2(43261596));  // 964176192
        System.out.println(solution3(43261596));  // 964176192
        System.out.println(solution6(43261596));  // 964176192
    }

}
