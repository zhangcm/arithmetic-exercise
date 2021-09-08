package arithmetic.exercise.tree.medium;

import arithmetic.exercise.common.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List [medium]
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * Input: root = [0]
 * Output: [0]
 */
public class FlatternBinaryTreeToLinkedList {

    private static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode oldRight = root.right;
        if (root.left != null) {
            root.right = root.left;
        }
        root.right.right = oldRight;
    }
}
