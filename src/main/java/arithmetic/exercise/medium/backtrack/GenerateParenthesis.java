package arithmetic.exercise.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
 */
public class GenerateParenthesis {

    private static final List<Character> candidate = Arrays.asList('(', ')');

    private static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder strb = new StringBuilder();
        backtrack(0, n * 2, strb, result);
        return result;
    }

    /**
     * 枚举所有的可能，最后校验
     */
    private static void backtrack(int index, int num, StringBuilder strb, List<String> result) {
        if (index == num) {
            if (isValid(strb)) {
                result.add(strb.toString());
            }
            return;
        }
        for (char s : candidate) {
            strb.append(s);
            backtrack(index + 1, num, strb, result);
            strb.deleteCharAt(index);
        }
    }

    private static boolean isValid(StringBuilder strb) {
        Deque<Character> deque = new LinkedList<>();
        int length = strb.length();
        for (int i = 0; i < length; i++) {
            char ch = strb.charAt(i);
            if (ch == '(') {
                deque.push(ch);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                char top = deque.pop();
                if (top != '(') {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    private static List<String> solution2(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder strb = new StringBuilder();
        backtrack(0, n * 2, strb, result);
        return result;
    }

    /**
     * 枚举的过程中也校验
     */
    private void backtrack2(int index, int num, StringBuilder strb, List<String> result) {
        if (invalid(strb, num)) {
            return;
        }
        if (index == num) {
            result.add(strb.toString());
            return;
        }
        for (char ch : candidate) {
            strb.append(ch);
            backtrack(index + 1, num, strb, result);
            strb.deleteCharAt(index);
        }
    }

    private static boolean invalid(StringBuilder strb, int num) {
        Deque<Character> deque = new LinkedList<>();
        int leftCount = 0;
        int rightCount = 0;
        int length = strb.length();
        for (int i = 0; i < length; i++) {
            char ch = strb.charAt(i);
            if (ch == '(') {
                leftCount++;
                deque.push(ch);
            } else {
                rightCount++;
                if (deque.isEmpty() || deque.pop() != '(') {
                    return true;
                }
            }
        }
        int max = num / 2 + 1;
        if (leftCount > max || rightCount > max) {
            return true;
        }
        if (length == num) {
            return !deque.isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));  // [()]
        System.out.println(solution(3));  // [((())), (()()), (())(), ()(()), ()()()]
        System.out.println(solution(4));
    }

}
