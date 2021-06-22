package arithmetic.exercise.medium.tree;

import arithmetic.exercise.common.ListUtils;
import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {

    private static List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        boolean reverse = false;
        TreeNode node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                if (reverse) {
                    node = queue.pollFirst();
                    level.add(node.val);
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                } else {
                    node = queue.pollLast();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                }
            }
            reverse = !reverse;
            list.add(level);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListUtils.println(TreeNodeUtils.levelOrder(root));
        ListUtils.println(solution(root));
    }
}
