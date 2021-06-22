package arithmetic.exercise.tree;

import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的中序遍历
 */
public class MidOrder {

    private static void recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        recursive(root.left);
        System.out.print(root.val + "  ");
        recursive(root.right);
    }

    /**
     * 中序遍历非递归
     *
     * 如果节点的左子树不为空，就将左子树推入栈
     * 如果为空，就出栈，并将右子树推入栈
     */
    private static void nonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {    // 左子树为空
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        nonRecursive(root);
    }

}
