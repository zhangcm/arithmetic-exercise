package arithmetic.exercise.easy.tree;

import arithmetic.exercise.common.TreeNode;

public class PreOrder {

    private static void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        solution(root.left);
        System.out.println(root.val);
        solution(root.right);
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
        TreeNode t6 = new TreeNode(11);

        root.left = t1;
        root.right = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;

        solution(root);
    }

}
