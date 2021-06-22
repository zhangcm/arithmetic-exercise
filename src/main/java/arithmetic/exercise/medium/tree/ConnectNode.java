package arithmetic.exercise.medium.tree;

import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 完美二叉树添加层级指针
 */
public class ConnectNode {

    private static TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null ) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    private static TreeNode solution2(TreeNode root) {
        // TODO 官方解答
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(new int[] {1, 2, 4, 5, 3, 6, 7}, new int[] {4, 2, 5, 1, 6, 3, 7});
        TreeNodeUtils.printLevelOrder(root);
        root = solution(root);
        System.out.println(root.val);
    }

}
