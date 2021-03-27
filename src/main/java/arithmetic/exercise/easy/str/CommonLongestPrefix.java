package arithmetic.exercise.easy.str;

public class CommonLongestPrefix {

    private static String solution(String[] strs) {
        String min = strs[0];
        for (String str : strs) {
            if (str.length() < min.length()) {
                min = str;
            }
        }
        int maxLength = min.length();
        for (int len = maxLength; len > 0; len--) {
            for (int i = 0; i < maxLength - len; i++) {
                String substr = min.substring(i, i + len);
                boolean allContains = true;
                for (String str : strs) {
                    if (!str.contains(substr)) {
                        allContains = false;
                        break;
                    }
                }
                if (allContains) {
                    return substr;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"cat", "dog", "pig"};
        System.out.println(solution(strs));
    }

}
