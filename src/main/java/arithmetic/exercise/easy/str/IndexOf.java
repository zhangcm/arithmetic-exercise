package arithmetic.exercise.easy.str;

public class IndexOf {

    private static int solution(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char first = needle.charAt(0);
        int beginIndex = -1;
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == first) {
                beginIndex = i;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(beginIndex + j) != needle.charAt(j)) {
                        beginIndex = -1;
                        break;
                    }
                }
                if (beginIndex > 0) {
                    break;
                }
            }
        }
        return beginIndex;
    }

    /**
     * TODO KMP算法
     */
    private static int solution1(String haystack, String needle) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("hell0", "ll"));
        System.out.println(solution("hello", "lll"));
        System.out.println(solution("hell0", ""));
        System.out.println(solution("hell0", " "));
    }

}
