package arithmetic.exercise.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class TreeNodeUtils {

    private TreeNodeUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * 基于数组构造一个二叉搜索树
     */
    public static TreeNode buildBST(int[] arr) {
        Arrays.sort(arr);
        return doBuildBST(arr, 0, arr.length - 1);
    }

    private static TreeNode doBuildBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = doBuildBST(arr, start, mid - 1);
        root.right = doBuildBST(arr, mid + 1, end);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode doBuildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        if (preorderStart == preorderEnd) {
            return new TreeNode(preorder[preorderStart]);
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        int newInorderStart = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                newInorderStart = i;
                break;
            }
        }
        if (newInorderStart == inorderStart) {
            root.left = null;
            root.right = doBuildTree(preorder, preorderStart + 1, preorderEnd, inorder, newInorderStart + 1, inorderEnd);
            return root;
        }
        if (newInorderStart == inorderEnd) {
            root.left  = doBuildTree(preorder, preorderStart + 1, preorderEnd, inorder, inorderStart, newInorderStart - 1);
            root.right = null;
            return root;
        }
        int leftEndNodVal = inorder[newInorderStart - 1];
        int newPreEnd = -1;
        for (int i = preorderStart; i <= preorderEnd; i++) {
            if (preorder[i] == leftEndNodVal) {
                newPreEnd = i;
                break;
            }
        }
        root.left = doBuildTree(preorder, preorderStart + 1, newPreEnd, inorder, inorderStart, newInorderStart - 1);
        root.right = doBuildTree(preorder, newPreEnd + 1, preorderEnd, inorder, newInorderStart + 1, inorderEnd);
        return root;
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printMidOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printMidOrder(root.left);
        System.out.print(root.val + " ");
        printMidOrder(root.right);
    }

    public static void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void printLevelOrder(TreeNode root) {
        ListUtils.println(levelOrder(root));
    }

    public static void main(String[] args) {
        //                     5
        //                    /  \
        //                   /     \
        //                 2         7
        //                / \       /  \
        //               /   \     /     \
        //              1     3   6       8
        //                     \           \
        //                      \           \
        //                       4           9
        //
        // TreeNode root = buildBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        // printPreOrder(root);
        // System.out.println();
        // printMidOrder(root);
        // System.out.println();
        // printPostOrder(root);

        TreeNode root = buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
        printPreOrder(root);
        System.out.println();
        printMidOrder(root);
        System.out.println();
        printPostOrder(root);
        System.out.println();
        printLevelOrder(root);
    }

}
