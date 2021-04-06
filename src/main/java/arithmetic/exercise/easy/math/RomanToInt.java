package arithmetic.exercise.easy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I-1  V-5  X-10  L-50  C-100  D-500  M-1000
 * I可以放在V和X的左边，表示4和9
 * X可以放在L和C的左边，表示40和90
 * C可以放在D和M的左边，表示400和900
 * 给定一个罗马数字，将其转为整数，输入确保在1到3999范围内
 */
public class RomanToInt {

    private static final Map<Character, Integer> map = new HashMap<>(7);
    private static final Map<String, Integer> specialMap = new HashMap<>(6);

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        specialMap.put("IV", 4);
        specialMap.put("IX", 9);
        specialMap.put("XL", 40);
        specialMap.put("XC", 90);
        specialMap.put("CD", 400);
        specialMap.put("CM", 900);
    }

    private static int solution(String s) {
        char[] arr = s.toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                String special = arr[i] + "" + arr[i + 1];
                if (specialMap.containsKey(special)) {
                    num += specialMap.get(special);
                    i++;
                    continue;
                }
            }
            num += map.get(arr[i]);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(solution("III"));       // 3
        System.out.println(solution("IV"));        // 4
        System.out.println(solution("IX"));        // 9
        System.out.println(solution("LVIII"));     // 58
        System.out.println(solution("MCMXCIV"));   // 1994
    }

}
