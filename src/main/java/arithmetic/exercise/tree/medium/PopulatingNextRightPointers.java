package arithmetic.exercise.tree.medium;

import arithmetic.exercise.common.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. Populating Next Right Pointers in Each Node [medium]
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 */
public class PopulatingNextRightPointers {

    /**
     * 递归解法
     */
    private static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    private static void connect(TreeNode left, TreeNode right) {
        if (left == null) {
            return;
        }
        left.next = right;
        connect(left.left, left.right);
        connect(right.left, right.right);
        connect(left.right, right.left);
    }

    /**
     * 迭代解法，层序遍历
     */
    private static TreeNode connect1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        TreeNode cur;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                cur.next = queue.peek();
                if (cur.left != null) {
                    queue.push(cur.left);
                }
                if (cur.right != null) {
                    queue.push(cur.right);
                }
            }
        }
        return root;
    }
}
