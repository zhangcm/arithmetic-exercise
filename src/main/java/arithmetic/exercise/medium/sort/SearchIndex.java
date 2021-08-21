package arithmetic.exercise.medium.sort;

/**
 * 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class SearchIndex {

    private static int solution(int[] nums, int target) {
        int length = nums.length;
        int targetIndex = -1;
        int rotateIndex = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                targetIndex = i;
            }
            if (i < length - 1 && nums[i] > nums[i + 1]) {
                rotateIndex = i + 1;
            }
        }
        if (targetIndex < 0) {
            return -1;
        }
        if (rotateIndex < 0) {
            return targetIndex;
        }
        return targetIndex >= rotateIndex ? targetIndex - rotateIndex : targetIndex + length - rotateIndex;
    }

    private static int solution2(int[] nums, int target) {
        int length = nums.length;
        int targetIndex = -1;
        int rotateIndex = 0;
        int mid;
        int start = 0, end = nums.length;
        int base = nums[0];
        while (start < end) {
            mid = (start + end) / 2;
            if (mid == 0) {
                break;
            }
            if (nums[mid] < base) {
                if (nums[mid - 1] >= base) {
                    rotateIndex = mid;
                    break;
                } else {
                    end = mid;
                }
            } else {
                start = mid + 1;
            }
        }
        start = base > target ? rotateIndex : 0;
        end = (base > target || rotateIndex == 0) ? length : rotateIndex;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (targetIndex < 0) {
            return -1;
        }
        return targetIndex >= rotateIndex ? targetIndex - rotateIndex : targetIndex + length - rotateIndex;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[] {0, 1, 2, 3}, 1));  // 1
        System.out.println(solution2(new int[] {4, 5, 6, 7, 0, 1, 2, 3}, 1));  // 1
        System.out.println(solution2(new int[] {4, 5, 6, 7, 0, 1, 2, 3}, 6));  // 6
        System.out.println(solution2(new int[] {0, 1, 2, 3, 4, 5, 6, 7}, 3));  // 3
        System.out.println(solution2(new int[] {5, 1, 2, 3}, 2));  // 1
        System.out.println(solution2(new int[] {5, 1, 2, 3}, 5));  // 3
        System.out.println(solution2(new int[] {5, 6, 7, 3}, 5));  // 1
        System.out.println(solution2(new int[] {5, 6, 7, 3}, 7));  // 3
        System.out.println(solution2(new int[] {5, 6, 7, 3}, 3));  // 0
    }

}
