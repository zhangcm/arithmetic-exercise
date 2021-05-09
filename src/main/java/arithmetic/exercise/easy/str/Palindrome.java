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

    private static boolean solution1(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        return reverse.toString().equals(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution1("aba"));
        System.out.println(solution1("ab"));
        System.out.println(solution1("a"));
    }

}
