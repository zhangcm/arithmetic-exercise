package arithmetic.exercise.tree;

import arithmetic.exercise.common.ListUtils;
import arithmetic.exercise.common.TreeNode;
import arithmetic.exercise.common.TreeNodeUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 层序遍历
 */
public class LevelOrder {

    private static void solution1(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    /**
     * 广度优先算法分别输出每一层
     */
    private static List<List<Integer>> solution2(TreeNode root) {
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

    /**
     * 深度优先算法
     */
    private static List<List<Integer>> solution3(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        doLevelOrder(root, 0, list);
        return list;
    }

    private static void doLevelOrder(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        List<Integer> currentLevelList;
        if (level >= list.size()) {
            currentLevelList = new ArrayList<>();
            list.add(level, currentLevelList);
        } else {
            currentLevelList = list.get(level);
        }
        currentLevelList.add(root.val);
        level++;
        doLevelOrder(root.left, level, list);
        doLevelOrder(root.right, level, list);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

        solution1(root);
        System.out.println();

        ListUtils.println(solution2(root));
        ListUtils.println(solution3(root));
    }

}
