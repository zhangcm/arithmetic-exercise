package arithmetic.exercise.easy.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 字母异位词
 */
public class Anagram {

    /**
     * 解决unicode
     * @param s1
     * @param s2
     * @return
     */
    private static boolean solution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int length = s1.length();
        Map<String, Integer> s1Map = new HashMap<>(length);
        Map<String, Integer> s2Map = new HashMap<>(length);
        String[] s1Arr = s1.split("");
        String[] s2Arr = s2.split("");

        for (int i = 0; i < length; i++) {
            s1Map.put(s1Arr[i], s1Map.getOrDefault(s1Arr[i], 0) + 1);
            s2Map.put(s2Arr[i], s2Map.getOrDefault(s2Arr[i], 0) + 1);
        }
        if (s1Map.size() != s2Map.size()) {
            return false;
        }
        for (String key : s1Map.keySet()) {
            if (!Objects.equals(s1Map.get(key), s2Map.get(key))) {
                return false;
            }
        }
        return true;
    }

    private static boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        int length = s.length();
        for (int i = 0; i < length; i++) {
            s1Map[s.charAt(i) - 'a'] = s1Map[s.charAt(i) - 'a'] + 1;
            s2Map[t.charAt(i) - 'a'] = s2Map[t.charAt(i) - 'a'] + 1;
        }
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean solution3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] stable = new int[26];

        int length = s.length();
        for (int i = 0; i < length; i++) {
            stable[s.charAt(i) - 'a'] = stable[s.charAt(i) - 'a'] + 1;
        }
        for (int i = 0; i < 26; i++) {
            stable[t.charAt(i) - 'a']--;
            if (stable[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean solution4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

}
