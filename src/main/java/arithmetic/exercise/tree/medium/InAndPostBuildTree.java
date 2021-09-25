package arithmetic.exercise.tree.medium;

import arithmetic.exercise.common.TreeNode;

/**
 * 106
 */
public class InAndPostBuildTree {

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        int inRootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                inRootIndex = i;
                break;
            }
        }
        int leftLength = inRootIndex - inStart;  // 算出左子树长度，依此可计算后续遍历左子树和右子树的索引范围
        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, postorder, inStart, inRootIndex - 1, postStart, postStart + leftLength - 1);
        root.right = build(inorder, postorder, inRootIndex + 1, inEnd, postStart + leftLength + 1, postEnd - 1);
        return root;
    }

}
