package arithmetic.exercise.easy.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从1到n数字的字符串表示
 * 1. 如果n是3的倍数，输出"Fizz"
 * 2. 如果n是5的倍数，输出"Buzz"
 * 3. 如果n同时是3和5的倍数，输出"FizzBuzz"
 */
public class FizzBuzz {

    public static List<String> solution(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            int mod3 = i % 3;
            int mod5 = i % 5;
            if (mod3 == 0) {
                if (mod5 == 0) {
                    list.add("FizzBuzz");
                } else {
                    list.add("Fizz");
                }
            } else if (mod5 == 0) {
                list.add("Buzz");
            } else {
                list.add(i + "");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

}
