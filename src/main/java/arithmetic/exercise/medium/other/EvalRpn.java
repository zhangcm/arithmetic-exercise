package arithmetic.exercise.medium.other;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 逆波兰表达式求值
 *
 * 根据逆波兰表示法，求表达式的值。
 * 有效的算符包括 +, -, *, /。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 1. 整数除法只保留整数部分
 * 2. 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为0的情况
 *
 * 示例：
 * token = ["2", "1", "+", "3", "*"] -> (2 + 1) * 3 = 9
 * token = ["4", "13", "5", "/", "+"] -> 4 + (13 / 5) = 6
 * token = ["10", "6", "9", "3", "+", "-11', "*", "/", "*", "17", "+", "5", "+"]
 * -> ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
 */
public class EvalRpn {

    private static int solution(String[] tokens) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int nums2 = stack.pop();
                int nums1 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = nums1 + nums2;
                        break;
                    case "-":
                        result = nums1 - nums2;
                        break;
                    case "*":
                        result = nums1 * nums2;
                        break;
                    case "/":
                        result = nums1 / nums2;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"2", "1", "+", "3", "*"}));  // 9
        System.out.println(solution(new String[] {"4", "13", "5", "/", "+"}));  // 6
        System.out.println(solution(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));  // 22
    }

}
