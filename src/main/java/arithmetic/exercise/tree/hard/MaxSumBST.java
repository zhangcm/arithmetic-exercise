package arithmetic.exercise.tree.hard;

import arithmetic.exercise.common.TreeCodec;
import arithmetic.exercise.common.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 1373
 */
public class MaxSumBST {

    private static int max = Integer.MIN_VALUE;

    private static int maxSumBST(TreeNode root) {
        traverse(root);
        return max;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (isBST(root)) {
            max = Math.max(sum(root), max);
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }

    private static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        return left + right + node.val;
    }

    private static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root.left) && isBST(root.right) &&
            (root.left == null || findMax(root.left).val < root.val) &&
            (root.right == null || findMin(root.right).val > root.val);
    }

    private static TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (true) {
            if (cur.left == null) {
                break;
            }
            cur = cur.left;
        }
        return cur;
    }

    private static TreeNode findMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (true) {
            if (cur.right == null) {
                break;
            }
            cur = cur.right;
        }
        return cur;
    }


    private static int maxSumBST1(TreeNode root) {
        Map<TreeNode, Result> map = new HashMap<>();
        calculate1(root, map);
        return max;
    }

    /**
     * 没想出来root为null时怎么赋初值，最大值赋Integer.MAX_VALUE，最小值赋Integer.MIN_VALUE，行不通
     */
    private static Result calculate(TreeNode root, Map<TreeNode, Result> map) {
        Result result;
        if (root == null) {
            return null;
        }
        result = map.get(root);
        if (result != null) {
            return result;
        }
        Result leftResult = calculate(root.left, map);
        Result rightResult = calculate(root.right, map);

        if (leftResult == null && rightResult == null) {
            result = new Result(true, root.val, root.val, root.val);
        } else if (leftResult == null) {
            if (rightResult.isBST && rightResult.min > root.val) {
                result = new Result(true, root.val, rightResult.max, rightResult.sum + root.val);
            }
        } else if (rightResult == null) {
            if (leftResult.isBST && leftResult.max < root.val) {
                result = new Result(true, leftResult.min, root.val, leftResult.sum + root.val);
            }
        } else if (leftResult.isBST && rightResult.isBST && leftResult.max < root.val && rightResult.min > root.val) {
            result = new Result(true, rightResult.max, leftResult.min, leftResult.sum + rightResult.sum + root.val);
        }
        if (result == null) {
            result = new Result(false);
        }
        map.put(root, result);
        max = Math.max(result.sum, max);
        return result;
    }

    private static Result calculate1(TreeNode root, Map<TreeNode, Result> map) {
        Result result;
        if (root == null) {
            return new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        result = map.get(root);
        if (result != null) {
            return result;
        }
        Result leftResult = calculate(root.left, map);
        Result rightResult = calculate(root.right, map);

        if (leftResult.isBST && rightResult.isBST && leftResult.max < root.val && rightResult.min > root.val) {
            // 比的时候用max，赋值的时候就会用min，通过Math.max和Math.min处理，root=null时可以给初始值
            result = new Result(true, Math.max(root.val, rightResult.max), Math.min(root.val, leftResult.min), leftResult.sum + rightResult.sum + root.val);
        }
        if (result == null) {
            result = new Result(false);
        }
        map.put(root, result);
        max = Math.max(result.sum, max);
        return result;
    }

    private static class Result {
        private boolean isBST;
        private int max;
        private int min;
        private int sum;

        public Result(boolean isBST) {
            this.isBST = isBST;
        }

        public Result(boolean isBST, int max, int min, int sum) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        max = 0;
        String s = "1,4,3,2,4,2,5,#,#,#,#,#,#,4,6";
        TreeNode root = TreeCodec.levelDeserialize(s);
        int result = maxSumBST1(root);  // 20
        System.out.println(result);
        s = "4,3,#,1,2,#,#,#,#";
        max = 0;
        root = TreeCodec.levelDeserialize(s);
        result = maxSumBST1(root);  // 2
        System.out.println(result);
        s = "-4,-2,-5";
        max = 0;
        root = TreeCodec.levelDeserialize(s);
        result = maxSumBST1(root);  // 0
        System.out.println(result);
        s = "2,1,3";
        max = 0;
        root = TreeCodec.levelDeserialize(s);
        result = maxSumBST1(root);  // 6
        System.out.println(result);
        s = "5,4,8,3,#,6,3";
        max = 0;
        root = TreeCodec.levelDeserialize(s);
        result = maxSumBST1(root);  // 7
        System.out.println(result);
    }
}
