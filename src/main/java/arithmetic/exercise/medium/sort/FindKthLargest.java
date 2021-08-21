package arithmetic.exercise.medium.sort;

import java.util.Arrays;
import java.util.TreeSet;
import org.junit.Assert;

/**
 * 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第K个最大的元素。请注意，你需要找的是数组排序后的第K个最大的元素，而不是第K个不同的元素
 */
public class FindKthLargest {

    private static int solution(int[] nums, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            if (treeSet.size() < k) {
                treeSet.add(num);
            } else if (treeSet.first() < num) {
                treeSet.pollFirst();
                treeSet.add(num);
            }
        }
        return treeSet.first();
    }

    private static int solution2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int result = solution(new int[] {3, 2, 1, 5, 6, 4}, 2);
        Assert.assertEquals(2, result);
    }

}
