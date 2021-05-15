package arithmetic.exercise.medium.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 */
public class LengthOfLongestSubstring {

    private static int solution(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int length = s.length();
        Set<Character> set = new HashSet<>(length < 4 ? 4 : length / 2);
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (set.add(ch)) {
                continue;
            }
            maxLength = Math.max(maxLength, set.size());
            for (int j = start; j < i; j++) {
                if (s.charAt(j) == ch) {
                    start = j + 1;
                    break;
                } else {
                    set.remove(s.charAt(j));
                }
            }
        }
        return Math.max(maxLength, set.size());
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcde"));
        System.out.println(solution("bbbbb"));
        System.out.println(solution("pwwkew"));
    }

}
