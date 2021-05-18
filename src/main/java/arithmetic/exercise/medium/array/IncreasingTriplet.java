package arithmetic.exercise.medium.array;

/**
 * 递增的三元子序列
 *
 * 给你一个整数数组nums，判断这个数组中是否存在长度为3的递增子序列。
 *
 * 如果存在这样的三元组下标(i, j, k)且满足i < j < k，使得nums[i] < nums[j] < nums[k]，返回true；
 * 否则，返回false
 */
public class IncreasingTriplet {

    /**
     * 三重循环
     */
    private static boolean solution(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j + 1; k < length; k++) {
                        if (nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 使用small和mid分别保存最小值和中间值
     *
     * 更新small和mid不会影响最后的结果。
     *
     * "即使更新了small，这个small在mid后面，没有严格遵守递增顺序，但它隐含着的真相是，
     * 有一个比small大比mid小的前最小值出现在mid之前。因为，当后续出现比mid大的值的时候，
     * 我们一样可以通过当前的small和mid推断的确存在着长度为3的递增序列。所以这样的替换
     * 并不会干扰我们后续的计算"
     */
    private static boolean solution2(int[] nums) {
        int length = nums.length;
        if (nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num < small) {
                small = num;
            } else if (num < mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4, 5}));
        System.out.println(solution(new int[] {5, 4, 3, 2, 1}));
        System.out.println(solution(new int[] {2, 1, 5, 0, 4, 6}));
    }


}
