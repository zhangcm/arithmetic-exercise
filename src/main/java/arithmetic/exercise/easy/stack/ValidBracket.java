package arithmetic.exercise.easy.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括'(', ')', '{', '}', '[', ']'的字符串s，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合
 * 2. 左括号必须以正确的顺序闭合
 */
public class ValidBracket {

    private static boolean solution(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Set<Character> right = map.keySet();

        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                char ch = s.charAt(i);
                if (right.contains(ch)) {
                    if (Objects.equals(stack.peek(), map.get(ch))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(solution("()"));      // true
        System.out.println(solution("()[]{}"));  // true
        System.out.println(solution("(]"));      // false
        System.out.println(solution("([)]"));    // false
        System.out.println(solution("{[]}"));    // true
    }
}
