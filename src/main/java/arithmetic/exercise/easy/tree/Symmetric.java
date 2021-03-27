package arithmetic.exercise.easy.tree;

import arithmetic.exercise.common.TreeNode;

public class Symmetric {

    private static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(5);
        // TreeNode n5 = new TreeNode(4);
        // TreeNode n6 = new TreeNode(4);

        root.left = n1;
        root.right = n2;

        root.left.left = n3;
        root.right.right = n4;
        // root.right.left = n5;
        // root.left.right = n6;
        System.out.println(solution(root));

    }
}
