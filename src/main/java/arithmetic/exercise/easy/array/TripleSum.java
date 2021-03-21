package arithmetic.exercise.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 三数之和
 */
public class TripleSum {

    public static List<List<Integer>> solution1(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            return Collections.singletonList(Arrays.asList(0, 0, 0));
        }
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; nums[i] <= 0 && i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; nums[j] >= 0 && j > i; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int k = search(nums, i + 1, j - 1, -(nums[i] + nums[j]));
                if (k > i && k < j) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[k]);
                    sub.add(nums[j]);
                    list.add(sub);
                }
            }
        }
        return list;
    }

    private static int search(int[] input, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        if (start == end && input[start] != target) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (input[middle] > target) {
            return search(input, start, middle, target);
        } else if (input[middle] < target) {
            return search(input, middle + 1, end, target);
        } else {
            return middle;
        }
    }

    public static List<List<Integer>> solution2(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        Set<String> exist = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sub = new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[k]);
                        Collections.sort(sub);
                        String temp = sub.get(0) + "#" + sub.get(1) + "#" + sub.get(2);
                        if (!exist.contains(temp)) {
                            exist.add(temp);
                            list.add(sub);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1, 2, 0, 4};
    }

}
