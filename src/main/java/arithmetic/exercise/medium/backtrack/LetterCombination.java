package arithmetic.exercise.medium.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class LetterCombination {

    private static final char[][] map = new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    public static List<String> solution(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        int length = digits.length();
        List<String> result = Collections.singletonList("");
        for (int i = 0; i < length; i++) {
            result = combine(result, map[digits.charAt(i) - 50]);
        }
        return result;
    }

    private static List<String> combine(List<String> list, char[] arr) {
        List<String> result = new ArrayList<>(list.size() * arr.length);
        for (String s : list) {
            for (char ch : arr) {
                result.add(s + ch);
            }
        }
        return result;
    }

    public static List<String> solution2(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, digits, 0, new StringBuilder());
        return combinations;
    }

    private static void backtrack(List<String> combinations, String digits, int index, StringBuilder strb) {
        int length = digits.length();
        if (index == length) {
            combinations.add(strb.toString());
            return;
        }
        char[] arr = map[digits.charAt(index) - '2'];
        for (char c : arr) {
            strb.append(c);
            backtrack(combinations, digits, index + 1, strb);
            strb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("23"));
        System.out.println(solution(""));
        System.out.println(solution("2"));
    }
}
