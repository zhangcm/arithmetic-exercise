package arithmetic.exercise.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum {

    /**
     * 官方解法
     */
    private static int[] solution(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    /**
     * 与官方解法类似，但是循环完了。没考虑要找 target - current
     */
    private static int[] solution2(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                if (nums[i] == nums[j]) {
                    return new int[] {map.get(nums[i]).get(0), map.get(nums[i]).get(1)};
                }
                return new int[] {map.get(nums[i]).get(0), map.get(nums[j]).get(0)};
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            }
        }
        return new int[0];
    }

    /**
     * 复制一个数组，进行排序，双指针找结果
     */
    private static int[] solution3(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        int[] temp = new int[nums.length];
        System.arraycopy(nums,0, temp, 0, nums.length);

        Arrays.sort(temp);
        int left = 0;
        int right = 0;

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (temp[i] + temp[j] == target) {
                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] == temp[i] && left == 0) {
                        left = k;
                    } else if (nums[k] == temp[j] && right == 0) {
                        right = k;
                    }
                }
                return new int[] {left, right};
            } else if (temp[i] + temp[j] < target) {
                i++;
            } else if (temp[i] + temp[j] > target) {
                j--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 7, 7, 3, 8, 9};
        int[] result = solution(nums, 14);
        System.out.println(Arrays.toString(result));
    }

}
