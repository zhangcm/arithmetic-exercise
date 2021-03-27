package arithmetic.exercise.easy.tree;

import arithmetic.exercise.common.TreeNode;

public class MaxDepth {

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        /*
         *              9
         *           /     \
         *         /         \
         *      5             17
         *        \          /   \
         *          7      13     21
         *                /
         *              11
         */

        TreeNode root = new TreeNode(9);

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(17);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(21);
        TreeNode t6 = new TreeNode(14);

        root.left = t1;
        root.right = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;

        System.out.println(maxDepth(root));
    }

}
