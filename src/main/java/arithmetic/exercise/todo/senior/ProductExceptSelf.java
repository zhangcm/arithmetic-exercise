package arithmetic.exercise.todo.senior;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * 给你一个长度为n的整数数组nums，其中 n > 1，返回输出数组output，其中output[i]等于nums中除nums[i]之外的其余各元素的乘积。
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在32位整数范围内。
 * 说明：请不要使用除法，且在O(n)时间复杂度内完成此题。
 * 进阶：你可以在常数空间复杂度内完成这个题目吗？（出于对空间复杂度分析的目的，输出数组不被视为额外空间）
 * 示例：
 * 输入[1, 2, 3, 4] -> [24, 12, 8, 6]
 */
public class ProductExceptSelf {

    private static int[] solution1(int[] nums) {
        int length = nums.length;
        int[] leftMultiResult = new int[length];
        leftMultiResult[0] = nums[0];
        int[] rightMultiResult = new int[length];
        rightMultiResult[length - 1] = nums[length - 1];
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                leftMultiResult[i] = nums[i] * leftMultiResult[i - 1];
            }
            if (i != length - 1) {
                rightMultiResult[length - i - 2] = rightMultiResult[length - i - 1] * nums[length - i - 2];
            }
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                result[i] = rightMultiResult[i + 1];
            } else if (i == length - 1) {
                result[i] = leftMultiResult[i - 1];
            } else {
                result[i] = leftMultiResult[i - 1] * rightMultiResult[i + 1];
            }
        }
        return result;
    }

    private static int[] solution(int[] nums) {
        int length = nums.length;
        int[] leftMultiResult = new int[length];
        leftMultiResult[0] = 1;
        int[] rightMultiResult = new int[length];
        rightMultiResult[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            leftMultiResult[i] = nums[i - 1] * leftMultiResult[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            rightMultiResult[i] = rightMultiResult[i + 1] * nums[i + 1];
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = leftMultiResult[i] * rightMultiResult[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4})));
    }

}
