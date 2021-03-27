package arithmetic.exercise.easy.tree;

import arithmetic.exercise.common.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

    private static TreeNode solution(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = build(nums, start, mid - 1);
        treeNode.right = build(nums, mid + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = solution(nums);
        System.out.println(treeNode);
    }

}
