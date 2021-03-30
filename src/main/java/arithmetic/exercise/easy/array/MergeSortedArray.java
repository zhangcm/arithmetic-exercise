package arithmetic.exercise.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并数组
 */
public class MergeSortedArray {

    /**
     * 合并数组时，为了避免移动较多的位置，可以从大往小合并
     */
    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                nums1[m + n - count - 1] = nums1[i];
                count++;
                i--;
            } else {
                nums1[m + n - count - 1] = nums2[j];
                count++;
                j--;
            }
        }
    }

    /**
     * 辅助数组，一个一个追加，然后复制
     */
    public static void solution2(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (j == n || (nums1[i] <= nums2[j] && i < m)) {
                arr[count++] = nums1[i];
                i++;
            } else if (j < n) {
                arr[count++] = nums2[j];
                j++;
            }
        }
        System.arraycopy(arr, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 4, 0, 0, 0};
        int[] nums2 = {2, 2, 5};
        solution2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
