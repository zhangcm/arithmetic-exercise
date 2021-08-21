package arithmetic.exercise.medium.sort;

/**
 * 寻找峰值
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可
 */
public class FindPeakElement {

    private static int solution(int[] nums) {
        return 0;
    }

    private static int solution2(int[] nums) {
        int endIndex = nums.length - 1;
        for (int i = 1; i < endIndex; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

    }
}
