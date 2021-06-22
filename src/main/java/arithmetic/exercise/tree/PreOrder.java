package arithmetic.exercise.tree;

import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 前序遍历
 */
public class PreOrder {

    /**
     * 递归
     */
    private static void recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        recursive(root.left);
        recursive(root.right);
    }

    /**
     * 深度优先遍历，借助栈来实现
     */
    private static void nonRecursive1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                cur = node.right;
            }
        }
    }

    /**
     * 深度优先遍历，借助栈来实现
     */
    private static void nonRecursive2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        recursive(root);
        System.out.println();
        nonRecursive2(root);
        System.out.println();
        nonRecursive2(root);
    }

}
