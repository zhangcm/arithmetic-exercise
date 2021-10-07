package arithmetic.exercise.bfs;

import arithmetic.exercise.common.TreeCodec;
import arithmetic.exercise.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth Of Binary Tree
 */
public class MinimumDepthOfBinaryTree {

    /**
     * TODO run
     */
    private static int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "3,9,20,#,#,15,7";
        TreeNode root = TreeCodec.levelDeserialize(s);
        System.out.println(minDepth(root));
        s = "2,#,3,#,4,#,5,#,6";
        root = TreeCodec.levelDeserialize(s);
        System.out.println(minDepth(root));
    }

}
