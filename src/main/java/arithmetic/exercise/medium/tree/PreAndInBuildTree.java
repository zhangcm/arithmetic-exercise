package arithmetic.exercise.medium.tree;

import arithmetic.exercise.common.TreeNode;

/**
 * 根据前序和中序构建二叉树
 */
public class PreAndInBuildTree {

    private TreeNode solution(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return solution(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode solution(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        if (preorderStart == preorderEnd) {
            return new TreeNode(preorder[preorderStart]);
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        int newMidStart = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                newMidStart = i;
                break;
            }
        }
        if (newMidStart == inorderStart) {
            root.left = null;
        }
        if (newMidStart == inorderEnd) {
            root.right = null;
        }
        int leftEndNodVal = inorder[newMidStart - 1];
        int newPreEnd = -1;
        for (int i = preorderStart; i <= preorderEnd; i++) {
            if (preorder[i] == leftEndNodVal) {
                newPreEnd = i;
                break;
            }
        }
        root.left = solution(preorder, preorderStart + 1, newPreEnd, inorder, inorderStart, newMidStart - 1);
        root.right = solution(preorder, newPreEnd + 1, preorderEnd, inorder, newMidStart + 1, inorderEnd);
        return root;
    }

}
