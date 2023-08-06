package arithmetic.exercise.easy.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Atoi {

    private static int solution(String s) {
        int result = 0;
        int symbol = 1;
        boolean hasSymbol = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && result == 0) {
                continue;
            } else if (ch == '-' || ch == '+') {
                if (hasSymbol) {
                    return 0;
                } else {
                    hasSymbol = true;
                    symbol = (ch == '-') ? -1 : 1;
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

    /**
     * 使用状态机
     */
    private static int solution1(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    static class Automaton {
        public int sign = 1;
        public long ans = 0;
        // 当前状态
        private String state = "start";

        private Map<String, String[]> table = new HashMap<String, String[]>() {
            {
                put("start", new String[] {"start", "signed", "in_number", "end"});
                put("signed", new String[] {"end", "end", "in_number", "end"});
                put("in_number", new String[] {"end", "end", "in_number", "end"});
                put("end", new String[] {"end", "end", "end", "end"});
            }
        };

        public void get(char c) {
            // 状态迁移
            state = table.get(state)[getCol(c)];
            if (Objects.equals(state, "in_number")) {
                ans = ans * 10 + (c - '0');
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if (Objects.equals(state, "signed")) {
                sign = (c == '+') ? 1 : -1;
            }
        }

        /**
         * 获取要迁移的状态的下标
         */
        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            } else if (c == '+' || c == '-') {
                return 1;
            } else if (Character.isDigit(c)) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(solution("-123456"));
//        System.out.println(solution("-123456789012"));
//        System.out.println(solution("123456789012"));
//        System.out.println(solution("+123456789012"));
//        System.out.println(solution("+1234+123"));
//        System.out.println(solution(" 789 my word"));
//        System.out.println(solution("my word  789 "));
//        System.out.println(solution("--"));
//        System.out.println(solution("-1-"));
//        System.out.println(solution("++"));]
        System.out.println(solution1("00000-42a1234"));
        System.out.println(solution1("-+12"));
        System.out.println(solution1("+-12"));
//        System.out.println(solution("42"));
    }
}
