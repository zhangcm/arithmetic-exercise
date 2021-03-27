package arithmetic.exercise.easy.str;

public class Atoi {

    private static int solution(String s) {
        int result = 0;
        int symbol = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '-') {
                if (result == 0 && symbol == 1) {
                    symbol = -1;
                } else {
                    break;
                }
            } else if (ch == '+') {
                if (result != 0) {
                    break;
                }
            } else if (ch < '0' || ch > '9') {
                break;
            } else {
                int temp = ch - '0';
                if (result > Integer.MAX_VALUE / 10) {
                    return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else if (result == Integer.MAX_VALUE / 10) {
                    if (symbol == 1 && temp > 7) {
                        return Integer.MAX_VALUE;
                    } else if (symbol == -1 && temp > 8) {
                        return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + temp;
            }
        }
        return result * symbol;
    }

    public static void main(String[] args) {
        System.out.println(solution("-123456"));
        System.out.println(solution("-123456789012"));
        System.out.println(solution("123456789012"));
        System.out.println(solution("+123456789012"));
        System.out.println(solution("+1234+123"));
        System.out.println(solution(" 789 my word"));
        System.out.println(solution("my word  789 "));
        System.out.println(solution("--"));
        System.out.println(solution("-1-"));
        System.out.println(solution("++"));
        System.out.println(solution("+1+"));
    }
}
