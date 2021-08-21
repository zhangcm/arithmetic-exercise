package arithmetic.exercise.medium.sort;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值target，返回[-1, -1]
 * 进阶：你可以设计并实现时间复杂度为O(logN)的算法解决此问题吗？
 * nums = [5, 7, 7, 8, 8, 10] target = 8 -> [3, 4]
 * nums = [5, 7, 7, 8, 8, 10] target = 6 -> [-1, -1]
 * nums = [] target = 8 -> [-1, -1]
 */
public class SearchRange {

    private static int[] solution(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        return searchRange(nums, 0, nums.length - 1, target);
    }

    private static int[] searchRange(int[] nums, int start, int end, int target) {
        if (start > end) {
            return new int[] {-1 , -1};
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            int from = mid;
            int to = mid;
            while ((from - 1 >= 0) && nums[from - 1] == target) {
                from--;
            }
            while ((to + 1 < nums.length) && nums[to + 1] == target) {
                to++;
            }
            return new int[] {from, to};
        } else if (nums[mid] > target) {
            return searchRange(nums, start, mid - 1, target);
        } else {
            return searchRange(nums, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution(new int[] {5, 7, 7, 8, 8, 10}, 10)));
        System.out.println(Arrays.toString(solution(new int[] {5, 7, 7, 8, 8, 10}, 5)));
        System.out.println(Arrays.toString(solution(new int[] {5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(solution(new int[] {}, 8)));
    }

}
