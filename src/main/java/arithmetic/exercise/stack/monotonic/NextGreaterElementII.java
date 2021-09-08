package arithmetic.exercise.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503
 */
public class NextGreaterElementII {

    private static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int j;
        for (int length = nums.length, i = length * 2 - 1; i >= 0; i--) {
            j = i % length;
            while (!stack.isEmpty() && stack.peek() <= nums[j]) {
                stack.pop();
            }
            result[j] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[j]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {4, 1, 2})));         // -1 3 -1
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {2, 4})));            // 3 -1
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {1, 2, 1})));         // 2 -1 2
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {1, 2, 3, 4, 3})));   // 2 3 4 -1 4
    }
}
