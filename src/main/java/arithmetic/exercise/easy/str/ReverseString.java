package arithmetic.exercise.easy.str;

import java.util.Arrays;

public class ReverseString {

    private static void solution(char[] s) {
        if (s.length < 2) {
            return;
        }
        int length = s.length;
        int end = length / 2;
        char temp;
        for (int i = 0; i < end; i++) {
            temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        char[] str = {'o', 'l', 'l', 'e', 'h'};
        solution(str);
        System.out.println(Arrays.toString(str));
    }

}
