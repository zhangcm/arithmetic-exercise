package arithmetic.exercise.easy.str;

import java.util.ArrayList;
import java.util.List;

public class ReverseNum {

    private static int solution(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int temp = x;
        List<Integer> list = new ArrayList<>();
        while (temp != 0) {
            list.add(temp % 10);
            temp = temp / 10;
        }
        int result = 0;
        int length = list.size();
        for (int i = 0; i < length - 1; i++) {
            result = result * 10 + list.get(i);
        }
        if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10
            || (result == Integer.MAX_VALUE / 10 && list.get(length - 1) > 7)
            || (result == Integer.MIN_VALUE / 10 && list.get(length - 1) > 8)) {
            return 0;
        }
        return result * 10 + list.get(length - 1);
    }

    private static int solution2(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        StringBuilder strb = new StringBuilder().append(x);
        String reverseStr = x > 0 ? strb.reverse().toString() : "-" + strb.deleteCharAt(0).reverse().toString();
        try {
            return Integer.parseInt(reverseStr);
        } catch (Exception e) {
            return 0;
        }

    }

    private static int solution3(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int temp = x;
        int result = 0;
        while (temp != 0) {
            if ((result * 10) / 10 != result) {
                return 0;
            }
            result = result * 10 + (temp % 10);
            temp = temp / 10;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution3(123));
        System.out.println(solution3(-123));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution3(Integer.MAX_VALUE / 10));
        System.out.println(solution3(Integer.MAX_VALUE));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(solution3(Integer.MIN_VALUE / 10));
        System.out.println(solution3(Integer.MIN_VALUE));
    }
}
