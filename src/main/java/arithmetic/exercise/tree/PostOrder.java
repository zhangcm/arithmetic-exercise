package arithmetic.exercise.tree;

import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;
import java.util.Deque;
import java.util.LinkedList;

public class PostOrder {

    private static void recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        recursive(root.left);
        recursive(root.right);
        System.out.print(root.val + " ");
    }

    /**                     5
     *                    /  \
     *                   /     \
     *                 2         7
     *                / \       /  \
     *               /   \     /     \
     *              1     3   6       8
     *                     \           \
     *                      \           \
     *                       4           9
     *
     * 1. 后序遍历要先输出左子树，所以遇到一个节点，如果它的左子树不为空，就先把它压入栈中。
     * 然后递归把左子树压入栈中，直到左子树为空。所以后序遍历的第一步是：递归压入左子树直到左子树为空
     * 2. 获取栈顶元素，
     * 2.1 左子树为空，右子树为空，说明已经是叶子节点了，可以直接出栈并打印
     * 2.2 左子树为空，右子树不为空，需要判断右子树有没有打印过。
     *   2.2.1 如果已经打印过，可以直接将当前节点出栈并打印。
     *   2.2.2 如果还未打印过，将右子树压入栈，重复第二步
     * 2.3 左子树不为空，因为2.1和2.2中已经打印过左子树，所以不能再处理左子树，直接按2.2的方式处理右子树
     *
     * 每个节点只会出栈一次，且只在出栈的时候打印。
     * 所以定义一个变量，用来标识上次打印的节点。当节点出栈时，更新这个变量。
     * 通过这个变量可以判断右子树有没有打印过。
     */
    private static void nonRecursive1(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode preVisit = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.right == null || preVisit == cur.right) {
                    System.out.print(cur.val + " ");
                    stack.pop();
                    preVisit = cur;
                    cur = null; // 避免向上回溯时重复把左子树压入栈中
                } else {
                    // 此时不需要将右子树推入栈中，因为cur不为空，走到上面的while语句时会把右子树压入栈中
                    // stack.push(cur.right);
                    cur = cur.right;
                }
            }
        }
    }

    /**
     * 后序遍历，使用辅助栈来保存数据
     * 节点压入stack2的时候，保持顺序左右根
     */
    private static void nonRecursive2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        TreeNode cur = root;
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        recursive(root);
        System.out.println();
        nonRecursive1(root);
        System.out.println();
        nonRecursive2(root);
    }

}
