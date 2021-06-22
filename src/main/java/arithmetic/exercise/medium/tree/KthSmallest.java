package arithmetic.exercise.medium.tree;

import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树第k小的元素
 */
public class KthSmallest {

    private static TreeNode solution(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        int index = 1;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (index++ == k) {
                    return current;
                }
                current = current.right;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(solution(root, 2).val);
        System.out.println(solution(root, 4).val);
        System.out.println(solution(root, 5).val);
        System.out.println(solution(root, 9).val);
    }

}
