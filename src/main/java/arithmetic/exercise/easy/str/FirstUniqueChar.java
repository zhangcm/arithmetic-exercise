package arithmetic.exercise.easy.str;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    private static int solution(String s) {
        if (s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char ch : arr) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int solution2(String s) {
        if (s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] counter = new int[26];
        for (char ch : arr) {
            counter[ch - 'a'] = counter[ch - 'a'] + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (counter[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
