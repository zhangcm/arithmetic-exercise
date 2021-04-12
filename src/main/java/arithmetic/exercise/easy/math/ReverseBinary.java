package arithmetic.exercise.easy.math;

/**
 * 颠倒二进制位
 *
 * 颠倒给定的32位无符号整数的二进制位
 */
public class ReverseBinary {

    private static int solution(int num) {
        for (int i = 0; i < 16; i++) {
            int low = num & (1 << i);
            int high = num & (1 << (31 - i));
            if (low == 0) {
                num = num & (0xffffffff - (1 << (31 - i)));
            } else {
                num = num | (1 << (31 - i));
            }
            if (high == 0) {
                num = num & (0xffffffff - (1 << i));
            } else {
                num = num | (1 << i);
            }
        }
        return num;
    }

    private static int solution2(int num) {
        // 有可能不足32位前面补0
        String s = Integer.toBinaryString(num);
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

    public static void main(String[] args) {
        System.out.println(solution(43261596));   // 964176192
        System.out.println(solution2(43261596));  // 964176192
    }

}
