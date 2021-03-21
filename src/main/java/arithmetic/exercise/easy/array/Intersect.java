package arithmetic.exercise.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数组求交集
 * 1. 排序 + 双指针
 * 2. map计数
 */
public class Intersect {

    private static int[] solution(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        if (nums1.length > nums2.length) {
            return solution(nums2, nums1);
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums1) {
            Integer value = numMap.get(num);
            Integer newValue = value == null ? 1 : ++value;
            numMap.put(num, newValue);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer existNums = numMap.get(num);
            if (existNums != null) {
                if (existNums > 0) {
                    list.add(num);
                    numMap.put(num, --existNums);
                }
            }
        }
        int length = list.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static int[] solution2(int nums1[], int nums2[]) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int length = list.size();
        int[] result = new int[length];
        for (int k = 0; k < length; k++) {
            result[k] = list.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {4, 9};
        int nums2[] = {9, 4, 9, 4, 5};
        int[] result = solution(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
