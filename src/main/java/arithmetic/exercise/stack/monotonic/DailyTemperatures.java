package arithmetic.exercise.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739
 */
public class DailyTemperatures {

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int length = temperatures.length, i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // 1 1 4 2 1 1 0 0
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
        // 1 1 1 0
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {30, 40, 50, 60})));
        // 1 1 0
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {30, 60, 90})));
    }

}
