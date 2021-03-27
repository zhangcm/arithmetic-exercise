package arithmetic.exercise.easy.str;

/**
 * 回文字符串
 * Character.isLetterOrDigit
 */
public class Palindrome {

    private static boolean solution(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                --j;
            }
            if (i < j) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                ++i;
                --j;
            }
        }
        return true;
    }

}
