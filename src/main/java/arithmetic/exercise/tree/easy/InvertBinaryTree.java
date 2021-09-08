package arithmetic.exercise.tree.easy;

import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;

/**
 * 226. Invert Binary Tree [easy]
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 */
public class InvertBinaryTree {

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBST(new int[] {4, 2, 7, 1, 3, 6, 9});
        TreeNodeUtils.printPreOrder(invertTree(root));
    }
}
