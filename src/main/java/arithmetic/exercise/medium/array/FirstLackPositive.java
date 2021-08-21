package arithmetic.exercise.medium.array;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组nums，找出其中没有出现的最小的正整数。  时间复杂度O(n)  空间复杂度O(1)
 */
public class FirstLackPositive {

    /**
     * 先排序，时间复杂度O(nlogn)
     */
    private static int solution(int[] nums) {
        Arrays.sort(nums);
        int current = 1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == current) {
                current++;
            } else if (nums[i] > current) {
                break;
            }
        }
        return current;
    }

    /**
     * 将正数一一对应放到对应的位置上，大于数组长度的不必关心，直接改为0
     * 第一个数字与索引不相等的就是要找的数
     */
    private static int solution1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] != i) {
                if (nums[i] > length - 1) {
                    nums[i] = 0;
                } else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[] {1, 2, 0}));       // 3
        System.out.println(solution1(new int[] {3, 4, -1, 1}));   // 2
        System.out.println(solution1(new int[] {7, 8, 9, 10}));   // 1
    }

}
